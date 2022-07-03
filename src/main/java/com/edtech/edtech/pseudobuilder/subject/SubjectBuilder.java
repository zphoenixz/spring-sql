package com.edtech.edtech.pseudobuilder.subject;

import com.edtech.edtech.model.document.Subject;
import com.edtech.edtech.model.schema.subject.CreateSubject;
import org.springframework.stereotype.Component;

@Component
public class SubjectBuilder {

    public Subject buildNewSubject(final CreateSubject createSubject) {
        return new Subject(
                createSubject.getName()
        );
    }
}
