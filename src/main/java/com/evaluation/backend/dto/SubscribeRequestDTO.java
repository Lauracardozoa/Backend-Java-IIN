package com.evaluation.backend.dto;

/*
     DTO used for in a subscribe/unsubscribe request having the courseId and userId fields
*/
public class SubscribeRequestDTO {
    private Integer courseId;

    private Integer userId;

    public SubscribeRequestDTO(Integer courseId, Integer userId) {
        this.courseId = courseId;
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
