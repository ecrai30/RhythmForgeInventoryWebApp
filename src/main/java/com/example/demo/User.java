package com.example.demo;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @NotEmpty(message = "Password is required")
    @Size(min=3) //Change after test
    private String password;

    @NotEmpty
    @NotNull
    private String confirm_password;

    @NotNull
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirm_password;
    }
    public void setConfirmPassword(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
