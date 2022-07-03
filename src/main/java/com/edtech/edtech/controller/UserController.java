package com.edtech.edtech.controller;

import com.edtech.edtech.handler.exceptions.ApiRestException;
import com.edtech.edtech.model.document.Classroom;
import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.classroom.AddToSubject;
import com.edtech.edtech.model.schema.user.CreateUser;
import com.edtech.edtech.model.schema.user.PatchUser;
import com.edtech.edtech.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public User createUser(final @Validated @RequestBody CreateUser createUser) throws ApiRestException {
        logger.info("POST request to */api/v1/user ENDPOINT*");
        return userService.createUser(createUser);
    }

    @GetMapping("{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getOrder(final @PathVariable("userId") Integer userId) throws Exception {
        logger.info("GET request to */api/v1/user/" + userId + " ENDPOINT*");
        return userService.getUser(userId);
    }

    @PatchMapping("{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public User patchUser(final @PathVariable("userId") Integer userId, final @Validated @RequestBody PatchUser patchUser) throws Exception {
        logger.info("PATCH request to */api/v1/user/" + userId + " ENDPOINT*");
        return userService.patchUser(userId, patchUser);
    }

    @PostMapping("{userId}/subject")
    @ResponseStatus(code = HttpStatus.OK)
    public Classroom addUserToSubject(final @PathVariable("userId") Integer userId, final @Validated @RequestBody AddToSubject addToSubject) throws ApiRestException {
        logger.info("POST request to */api/v1/user/" + userId + "/subject ENDPOINT*");
        return userService.addUserToSubject(userId, addToSubject);
    }

    @GetMapping("{userId}/subject")
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Classroom> getUserClassrooms(final @PathVariable("userId") Integer userId) throws ApiRestException {
        logger.info("GET request to */api/v1/user/" + userId + "/subject ENDPOINT*");
        return userService.getUserClassrooms(userId);
    }

    @DeleteMapping("{userId}/subject/{subjectId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Classroom> deleteUserFromSubject(final @PathVariable("userId") Integer userId, final @PathVariable("subjectId") Integer subjectId) throws ApiRestException {
        logger.info("POST request to */api/v1/user/" + userId + "/subject/" + subjectId + " ENDPOINT*");
        return userService.deleteUserFromSubject(userId, subjectId);
    }
}
