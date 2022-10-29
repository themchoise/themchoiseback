package com.themchoisebackend.themchoisebackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String login;
    private String password;
     static Date last_updated;

    public User(){}

    public User(Long id, String login, String password){
        this.id=id;
        this.login=login;
        this.password=password;
    }

    public String getData(){
        return this.login+" |  "+this.password;
    }

}
