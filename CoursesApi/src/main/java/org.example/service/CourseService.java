package org.example.service;

import org.example.entity.Course;
import org.example.entity.Prerequisite;
import org.example.entity.PrerequisiteId;
import org.example.exception.CourseDependencyException;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.CourseRepository;
import org.example.repository.PrerequisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private PrerequisiteRepository prerequisiteRepository;

    public ResponseEntity<?> createCourse(Course course) {
        for (Prerequisite prerequisite : course.getPrerequisites()) {
            if (!courseRepository.existsByCourseId(prerequisite.getPrerequisiteId())) {
                return ResponseEntity.badRequest().body("Prerequisite " + prerequisite.getPrerequisiteId() + " does not exist");
            }
        }
        courseRepository.save(course);
        return ResponseEntity.ok(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String courseId) {
        return courseRepository.findByCourseId(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    public ResponseEntity<?> deleteCourse(String courseId) {
        if (prerequisiteRepository.existsByIdPrerequisiteId(courseId)) {
            throw new CourseDependencyException("Course " + courseId + " is a prerequisite and cannot be deleted");
        }
        Course course = courseRepository.findByCourseId(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        courseRepository.delete(course);
        return ResponseEntity.ok("Deleted");
    }
}
