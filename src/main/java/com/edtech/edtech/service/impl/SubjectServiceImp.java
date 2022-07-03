package com.edtech.edtech.service.impl;


import com.edtech.edtech.handler.exceptions.ApiRestException;
import com.edtech.edtech.model.document.Classroom;
import com.edtech.edtech.model.document.Subject;
import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.subject.CreateSubject;
import com.edtech.edtech.pseudobuilder.subject.SubjectBuilder;
import com.edtech.edtech.repository.ClassroomRepository;
import com.edtech.edtech.repository.SubjectRepository;
import com.edtech.edtech.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SubjectServiceImp implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private SubjectBuilder subjectBuilder;

    @Override
    public Subject createSubject(final CreateSubject createSubject) throws ApiRestException{
        final Subject subjectInDb = subjectRepository.findSubjectByName(createSubject.getName());
        if(subjectInDb != null){
            throw new ApiRestException("Subject already exists.");
        }
        return subjectRepository.save(subjectBuilder.buildNewSubject(createSubject));
    }

    @Override
    public Subject getSubject(final Integer subjectId) throws ApiRestException{
        final Subject subjectInDb = subjectRepository.findSubjectBySubjectId(subjectId);
        if(subjectInDb == null){
            throw new ApiRestException("Subject doesn't exists.");
        }
        return subjectInDb;
    }

    @Override
    public Set<Classroom> getSubjectUsers(final Integer subjectId) throws ApiRestException{
        final Subject subjectInDb = subjectRepository.findSubjectBySubjectId(subjectId);
        if(subjectInDb == null){
            throw new ApiRestException("Subject doesn't exists.");
        }
        final Set<Classroom> classroomInDb = classroomRepository.findSubjectUsers(subjectInDb.getSubjectId());
        if(classroomInDb.size() == 0){
            throw new ApiRestException("Subject has none signed users.");
        }
        return classroomInDb;
    }
}
