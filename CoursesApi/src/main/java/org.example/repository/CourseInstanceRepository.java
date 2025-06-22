package org.example.repository;

import org.example.entity.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
    Optional<CourseInstance> findByCourseIdAndYearAndSemester(String courseId, int year, int semester);
    void deleteByCourseIdAndYearAndSemester(String courseId, int year, int semester);
}
