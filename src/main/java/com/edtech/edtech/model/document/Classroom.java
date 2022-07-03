package com.edtech.edtech.model.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "Classroom")
@Table(name = "classroom")
public class Classroom {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "subject_subject_id", nullable = false)
    private Subject subjectSubject;

    public Classroom() {
    }

    public Classroom(final User userUser, final Subject subjectSubject) {
        this.userUser = userUser;
        this.subjectSubject = subjectSubject;
    }

    public Classroom(final Integer classroomId, final User userUser, final Subject subjectSubject) {
        this.classroomId = classroomId;
        this.userUser = userUser;
        this.subjectSubject = subjectSubject;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(final Integer classroomId) {
        this.classroomId = classroomId;
    }

    public User getUserUser() {
        return userUser;
    }

    public void setUserUser(final User userUser) {
        this.userUser = userUser;
    }

    public Subject getSubjectSubject() {
        return subjectSubject;
    }

    public void setSubjectSubject(final Subject subjectSubject) {
        this.subjectSubject = subjectSubject;
    }

}
