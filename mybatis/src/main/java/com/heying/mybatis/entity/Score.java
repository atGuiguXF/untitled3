package com.heying.mybatis.entity;

import java.io.Serializable;

public class Score implements Serializable {

    private Integer id;

    private Course course;

    private Integer score;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Score() {
    }

    public Score(Integer score) {
        this.score = score;
    }
}
