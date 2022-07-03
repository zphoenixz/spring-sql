package com.edtech.edtech.repository;

import com.edtech.edtech.model.document.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserName(final String userName);
    User findUserByUserId(final Integer userId);
}
