package com.edtech.edtech.pseudobuilder.user;

import com.edtech.edtech.model.document.User;
import com.edtech.edtech.model.schema.user.CreateUser;
import com.edtech.edtech.model.schema.user.PatchUser;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    public User buildNewUser(final CreateUser createUser) {
        return new User(
                createUser.getFirstName(),
                createUser.getLastName(),
                createUser.getUserName(),
                createUser.getPassword()
        );
    }

    public User buildPatchUser(final User userInDb, final PatchUser patchUser) {
        return new User(
                userInDb.getUserId(),
                patchUser.getFirstName().orElse(userInDb.getFirstName()),
                patchUser.getLastName().orElse(userInDb.getLastName()),
                userInDb.getUserName(),
                userInDb.getPassword()
        );
    }
}
