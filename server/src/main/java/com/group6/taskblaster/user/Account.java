package com.group6.taskblaster.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Account {
    
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    
    private @Id @GeneratedValue long id;

    private String name;

    private @JsonIgnore String password;

    private String[] roles;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    private Account() {} 

    public Account(String name, String password, String ... roles) {
        
        this.name = name;
        this.setPassword(password);
        this.roles = roles;
    }

    public long getId() { return this.id; }
    public String getName() { return this.name; }
    public String getPassword() { return this.password; }
    public String[] getRoles() { return this.roles; }

    public void setName(String name) { this.name = name; }
}