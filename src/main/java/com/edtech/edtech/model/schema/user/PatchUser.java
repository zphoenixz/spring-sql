package com.edtech.edtech.model.schema.user;

import com.edtech.edtech.utils.constants.Regex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Optional;

public class PatchUser {

    @Pattern(regexp = Regex.TRIMMED_NO_BLANK_MIN_1_MAX_256_W_WHITESPACE)
    private String firstName;

    @Pattern(regexp = Regex.TRIMMED_NO_BLANK_MIN_1_MAX_256_W_WHITESPACE)
    private String lastName;


    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName) ;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

}
