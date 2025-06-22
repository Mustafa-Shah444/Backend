package org.example.repository;

import org.example.entity.Prerequisite;
import org.example.entity.PrerequisiteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrerequisiteRepository extends JpaRepository<Prerequisite, PrerequisiteId> {
    List<Prerequisite> findByIdCourseId(String courseId);
    boolean existsByIdPrerequisiteId(String prerequisiteId);
}