package com.edtech.edtech.controller;

import com.edtech.edtech.handler.exceptions.ApiRestException;
import com.edtech.edtech.model.document.Classroom;
import com.edtech.edtech.model.document.Subject;
import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.subject.CreateSubject;
import com.edtech.edtech.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    private Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Subject createSubject(final @Validated @RequestBody CreateSubject createSubject) throws ApiRestException {
        logger.info("POST request to */api/v1/subject ENDPOINT*");
        return subjectService.createSubject(createSubject);
    }

    @GetMapping("{subjectId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Subject getSubject(final @PathVariable("subjectId") Integer subjectId) throws Exception {
        logger.info("GET request to */api/v1/subject/" + subjectId + " ENDPOINT*");
        return subjectService.getSubject(subjectId);
    }

    @GetMapping("{subjectId}/user")
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Classroom> getSubjectUsers(final @PathVariable("subjectId") Integer subjectId) throws Exception {
        logger.info("GET request to */api/v1/subject/" + subjectId + " ENDPOINT*");
        return subjectService.getSubjectUsers(subjectId);
    }
}
