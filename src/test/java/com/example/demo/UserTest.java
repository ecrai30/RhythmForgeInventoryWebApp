package com.example.demo;

import com.example.demo.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    @BeforeEach
    public void setUp(){
        user =new User();
    }


    @Test
    void getId() {
        int id = 3;
        user.setId(id);
        assertEquals(id, user.getId());

    }

    @Test
    void setId() {
        int id = 3;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void getName() {
        String name = "Ezekiel";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    void setName() {
        String name = "Ezekiel";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    void getEmail() {
        String emailValue = "ezekiel@gmail.com";
        user.setEmail(emailValue);
        assertEquals(emailValue, user.getEmail());
    }

    @Test
    void setEmail() {
        String emailValue = "ezekiel@gmail.com";
        user.setEmail(emailValue);
        assertEquals(emailValue, user.getEmail());
    }

    @Test
    void getUsername() {
        String Uname = "Ezekiel27";
        user.setUsername(Uname);
        assertEquals(Uname, user.getUsername());

    }

    @Test
    void setUsername() {
        String Uname = "Ezekiel27";
        user.setUsername(Uname);
        assertEquals(Uname, user.getUsername());
    }

    @Test
    void getPassword() {
        String pass = "ezekiel2024";
        user.setPassword(pass);
        assertEquals(pass, user.getPassword());
    }

    @Test
    void setPassword() {
        String pass = "ezekiel2024";
        user.setPassword(pass);
        assertEquals(pass, user.getPassword());
    }

    @Test
    void getConfirmPassword() {
        String cpass = "ezekiel2024";
        user.setPassword(cpass);
        assertEquals(cpass, user.getPassword());
    }

    @Test
    void setConfirmPassword() {
        String cpass = "ezekiel2024";
        user.setPassword(cpass);
        assertEquals(cpass, user.getPassword());
    }
}