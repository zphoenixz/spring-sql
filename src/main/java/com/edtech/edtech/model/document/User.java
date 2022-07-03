package com.edtech.edtech.model.document;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "user_id",
            updatable = false
    )
    private Integer userId;

    @Column(
            name = "first_name"
    )
    private String firstName;

    @Column(
            name = "last_name"
    )
    private String lastName;

    @Column(
            name = "user_name",
            nullable = false,
            unique = true
    )
    private String userName;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "userUser")
    private Set<Classroom> userUserClassrooms;

    public User() {
    }

    public User(final Integer userId, final String firstName, final String lastName, final String userName, final String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User(final String firstName, final String lastName, final String userName, final String password) {
        this.userId = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Classroom> getUserUserClassrooms() {
        return userUserClassrooms;
    }

    public void setUserUserClassrooms(final Set<Classroom> userUserClassrooms) {
        this.userUserClassrooms = userUserClassrooms;
    }
}
