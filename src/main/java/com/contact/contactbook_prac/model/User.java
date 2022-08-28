package com.contact.contactbook_prac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "first name cannot be empty.")
    @Size(min = 5, max = 20)
    private String firstName;

    @NotEmpty(message = "last name cannot be empty.")
    @Size(min = 5, max = 20)
    private String lastName;

    @NotEmpty(message = "username cannot be empty.")
    @Size(min = 5, max = 20)
    private String userName;

    @Email(message = "email cannot be empty.")
    private String email;

    @NotEmpty(message = "password cannot be empty.")
    @Size(min = 8)
    private String password;

    // private boolean checkbox;

    public User() {
    }

    public User(int id, String firstName, String lastName, String userName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        // this.checkbox = checkbox;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [checkbox=" + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
                + ", password=" + password + ", userName=" + userName + "]";
    }

}
