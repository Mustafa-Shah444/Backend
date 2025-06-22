package org.example.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrerequisiteId implements Serializable {

    private String courseId;
    private String prerequisiteId;

    public PrerequisiteId() {}

    public PrerequisiteId(String courseId, String prerequisiteId) {
        this.courseId = courseId;
        this.prerequisiteId = prerequisiteId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getPrerequisiteId() {
        return prerequisiteId;
    }

    public void setPrerequisiteId(String prerequisiteId) {
        this.prerequisiteId = prerequisiteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrerequisiteId)) return false;
        PrerequisiteId that = (PrerequisiteId) o;
        return Objects.equals(courseId, that.courseId) &&
                Objects.equals(prerequisiteId, that.prerequisiteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, prerequisiteId);
    }
}
