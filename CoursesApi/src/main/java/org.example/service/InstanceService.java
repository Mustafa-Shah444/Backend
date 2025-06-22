package org.example.service;

import org.example.entity.CourseInstance;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstanceService {

    @Autowired
    private CourseInstanceRepository instanceRepository;

    public CourseInstance createInstance(CourseInstance instance) {
        return instanceRepository.save(instance);
    }

    public List<CourseInstance> getByYearAndSemester(int year, int semester) {
        return instanceRepository.findByYearAndSemester(year, semester);
    }

    public CourseInstance getByCourseIdAndYearSemester(String courseId, int year, int semester) {
        return instanceRepository.findByCourseIdAndYearAndSemester(courseId, year, semester)
                .orElseThrow(() -> new ResourceNotFoundException("Instance not found"));
    }

    public ResponseEntity<?> deleteInstance(String courseId, int year, int semester) {
        instanceRepository.deleteByCourseIdAndYearAndSemester(courseId, year, semester);
        return ResponseEntity.ok("Deleted");
    }
}
