package org.example.controller;

import org.example.entity.CourseInstance;
import org.example.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class InstanceController {

    @Autowired
    private InstanceService instanceService;

    @PostMapping
    public CourseInstance createInstance(@RequestBody CourseInstance instance) {
        return instanceService.createInstance(instance);
    }

    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearSemester(@PathVariable int year, @PathVariable int semester) {
        return instanceService.getByYearAndSemester(year, semester);
    }

    @GetMapping("/{year}/{semester}/{courseId}")
    public CourseInstance getInstance(@PathVariable int year, @PathVariable int semester, @PathVariable String courseId) {
        return instanceService.getByCourseIdAndYearSemester(courseId, year, semester);
    }

    @DeleteMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<?> deleteInstance(@PathVariable int year, @PathVariable int semester, @PathVariable String courseId) {
        return instanceService.deleteInstance(courseId, year, semester);
    }
}
