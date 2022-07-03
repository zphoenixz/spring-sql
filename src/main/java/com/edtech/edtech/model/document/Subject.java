package com.edtech.edtech.model.document;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity(name = "Subject")
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "subject_id",
            updatable = false
    )
    private Integer subjectId;

    @Column(
            name = "name",
            nullable = false,
            unique = true
    )
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subjectSubject")
    private Set<Classroom> subjectSubjectClassrooms;

    public Subject() {
    }

    public Subject(final String name) {
        this.subjectId = null;
        this.name = name;
    }
    public Subject(final Integer subjectId, final String name) {
        this.subjectId = subjectId;
        this.name = name;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Classroom> getSubjectSubjectClassrooms() {
        return subjectSubjectClassrooms;
    }

    public void setSubjectSubjectClassrooms(final Set<Classroom> subjectSubjectClassrooms) {
        this.subjectSubjectClassrooms = subjectSubjectClassrooms;
    }
}
