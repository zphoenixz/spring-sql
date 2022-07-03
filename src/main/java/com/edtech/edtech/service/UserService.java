package com.edtech.edtech.service;

import com.edtech.edtech.handler.exceptions.ApiRestException;
import com.edtech.edtech.model.document.Classroom;
import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.classroom.AddToSubject;
import com.edtech.edtech.model.schema.user.CreateUser;
import com.edtech.edtech.model.schema.user.PatchUser;

import java.util.Set;

public interface UserService {
    User createUser(final CreateUser createUser) throws ApiRestException;
    User getUser(final Integer userId) throws ApiRestException;
    User patchUser(final Integer userId, final PatchUser patchUser) throws ApiRestException;
    Classroom addUserToSubject(final Integer userId, final AddToSubject addToSubject) throws ApiRestException;
    Set<Classroom> getUserClassrooms(final Integer userId) throws ApiRestException;
    Set<Classroom> deleteUserFromSubject(final Integer userId, final Integer subjectId) throws ApiRestException;
}
