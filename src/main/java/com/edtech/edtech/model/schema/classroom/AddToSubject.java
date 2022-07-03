package com.edtech.edtech.model.schema.classroom;

import javax.validation.constraints.NotNull;

public class AddToSubject {
    @NotNull(message = "A name subjectId is required")
    private Integer subjectId;

    public Integer getSubjectId() {
        return subjectId;
    }
}
