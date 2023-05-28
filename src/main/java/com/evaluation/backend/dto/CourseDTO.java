package com.evaluation.backend.dto;

import com.evaluation.backend.model.Course;
import com.evaluation.backend.service.CourseService;

import java.time.LocalTime;

public class CourseDTO {
    private Integer id;

    private String title;

    private String description;

    private float rating;

    private Integer nreviews;

    private LocalTime duration;

    public CourseDTO(Integer id, String title, String description, float rating, Integer nreviews, LocalTime duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.nreviews = nreviews;
        this.duration = duration;
    }

    public CourseDTO(Course course){
        this.id = course.getId();
        this.title = course.getTitle();
        this.description = course.getDescription();
        this.rating = course.getRating();
        this.nreviews = course.getnReviews();
        this.duration = course.getDuration();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Integer getNreviews() {
        return nreviews;
    }

    public void setNreviews(Integer nreviews) {
        this.nreviews = nreviews;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
