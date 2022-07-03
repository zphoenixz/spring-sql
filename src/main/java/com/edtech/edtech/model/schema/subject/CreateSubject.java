package com.edtech.edtech.model.schema.subject;

import com.edtech.edtech.utils.constants.Regex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateSubject {
    @NotNull(message = "A name field is required")
    @Pattern(regexp = Regex.TRIMMED_NO_BLANK_MIN_1_MAX_256_W_WHITESPACE)
    private String name;

    public String getName() {
        return name;
    }
}
