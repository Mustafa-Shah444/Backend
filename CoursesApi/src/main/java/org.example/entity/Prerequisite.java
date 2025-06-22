package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prerequisites")
public class Prerequisite {

    @EmbeddedId
    private PrerequisiteId id;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public PrerequisiteId getId() {
        return id;
    }

    public void setId(PrerequisiteId id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPrerequisiteId() {
        return id != null ? id.getPrerequisiteId() : null;
    }

    public void setPrerequisiteId(String prerequisiteId) {
        if (id == null) id = new PrerequisiteId();
        id.setPrerequisiteId(prerequisiteId);
    }
}
