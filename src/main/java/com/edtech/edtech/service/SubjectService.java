package com.edtech.edtech.service;

import com.edtech.edtech.handler.exceptions.ApiRestException;
import com.edtech.edtech.model.document.Classroom;
import com.edtech.edtech.model.document.Subject;
import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.subject.CreateSubject;

import java.util.List;
import java.util.Set;

public interface SubjectService {

    Subject createSubject(final CreateSubject createSubject) throws ApiRestException;
    Subject getSubject(final Integer subjectId) throws ApiRestException;
    Set<Classroom> getSubjectUsers(final Integer subjectId) throws ApiRestException;
}
