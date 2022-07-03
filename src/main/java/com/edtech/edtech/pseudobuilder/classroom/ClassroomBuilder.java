package com.edtech.edtech.pseudobuilder.classroom;

import com.edtech.edtech.model.document.Classroom;
import com.edtech.edtech.model.document.Subject;
import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.subject.CreateSubject;
import org.springframework.stereotype.Component;

@Component
public class ClassroomBuilder {

    public Classroom buildAddUserToSubject(final User user, final Subject subject) {
        return new Classroom(
                user,
                subject
        );
    }
}
