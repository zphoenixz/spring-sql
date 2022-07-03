package com.edtech.edtech.repository;

import com.edtech.edtech.model.document.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findSubjectByName(final String name);
    Subject findSubjectBySubjectId(final Integer subjectId);
}
