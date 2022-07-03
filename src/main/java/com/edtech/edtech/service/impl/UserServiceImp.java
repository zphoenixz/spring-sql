package com.edtech.edtech.service.impl;


import com.edtech.edtech.handler.exceptions.ApiRestException;
import com.edtech.edtech.model.document.Classroom;
import com.edtech.edtech.model.document.Subject;
import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.classroom.AddToSubject;
import com.edtech.edtech.model.schema.user.CreateUser;
import com.edtech.edtech.model.schema.user.PatchUser;
import com.edtech.edtech.pseudobuilder.classroom.ClassroomBuilder;
import com.edtech.edtech.pseudobuilder.user.UserBuilder;
import com.edtech.edtech.repository.ClassroomRepository;
import com.edtech.edtech.repository.SubjectRepository;
import com.edtech.edtech.repository.UserRepository;
import com.edtech.edtech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserBuilder userBuilder;
    @Autowired
    private ClassroomBuilder classroomBuilder;

    @Override
    public User createUser(final CreateUser createUser) throws ApiRestException{
        final User userInDb = userRepository.findUserByUserName(createUser.getUserName());
        if(userInDb != null){
            throw new ApiRestException("User already exists.");
        }
        createUser.setPassword(passwordEncoder.encode(createUser.getPassword()));
        return userRepository.save(userBuilder.buildNewUser(createUser));
    }

    @Override
    public User getUser(final Integer userId) throws ApiRestException{
        final User userInDb = userRepository.findUserByUserId(userId);
        if(userInDb == null){
            throw new ApiRestException("User doesn't exists.");
        }
        return userInDb;
    }

    @Override
    public User patchUser(final Integer userId, final PatchUser patchUser) throws ApiRestException{
        final User userInDb = userRepository.findUserByUserId(userId);
        if(userInDb == null){
            throw new ApiRestException("User doesn't exists.");
        }
        return userRepository.save(userBuilder.buildPatchUser(userInDb, patchUser));
    }

    @Override
    public Classroom addUserToSubject(final Integer userId, final AddToSubject addToSubject) throws ApiRestException{
        final User userInDb = userRepository.findUserByUserId(userId);
        if(userInDb == null){
            throw new ApiRestException("User doesn't exists.");
        }
        final Subject subjectInDb = subjectRepository.findSubjectBySubjectId(addToSubject.getSubjectId());
        if(subjectInDb == null){
            throw new ApiRestException("Subject doesn't exists.");
        }
        final Classroom classroomInDb = classroomRepository.findUserSubject(userInDb.getUserId(), subjectInDb.getSubjectId());
        if(classroomInDb != null){
            throw new ApiRestException("User already added to the classroom.");
        }
        return classroomRepository.save(classroomBuilder.buildAddUserToSubject(userInDb, subjectInDb));
    }

    @Override
    public Set<Classroom> getUserClassrooms(final Integer userId) throws ApiRestException{
        final User userInDb = userRepository.findUserByUserId(userId);
        if(userInDb == null){
            throw new ApiRestException("User doesn't exists.");
        }
        final Set<Classroom> classroomInDb = classroomRepository.findUserSubjects(userInDb.getUserId());
        if(classroomInDb.size() == 0){
            throw new ApiRestException("User has not signed to any subject.");
        }
        return classroomInDb;
    }

    @Override
    public Set<Classroom> deleteUserFromSubject(final Integer userId, final Integer subjectId) throws ApiRestException{
        final User userInDb = userRepository.findUserByUserId(userId);
        if(userInDb == null){
            throw new ApiRestException("User doesn't exists.");
        }
        final Subject subjectInDb = subjectRepository.findSubjectBySubjectId(subjectId);
        if(subjectInDb == null){
            throw new ApiRestException("Subject doesn't exists.");
        }
        final Classroom classroomInDb = classroomRepository.findUserSubject(userInDb.getUserId(), subjectInDb.getSubjectId());
        if(classroomInDb == null){
            throw new ApiRestException("User already unsigned of the classroom.");
        }
        classroomRepository.delete(classroomInDb);

        return classroomRepository.findUserSubjects(userInDb.getUserId());
    }

}
