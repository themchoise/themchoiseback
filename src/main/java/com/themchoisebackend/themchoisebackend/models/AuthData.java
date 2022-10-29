package com.themchoisebackend.themchoisebackend.models;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class AuthData {

    private boolean ok;
    private String token;
    private long uid;
    private String login;

    public AuthData(){}

    public AuthData(boolean ok, String token, long uid,String login ){
        this.ok=ok;
        this.token=token;
        this.uid=uid;
        this.login=login;
    }




}