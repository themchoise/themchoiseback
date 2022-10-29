package com.themchoisebackend.themchoisebackend.models;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class Data {

    private boolean status;
    private List data;
    private String error;

    public Data(){}

    public Data(boolean status, List data, String error){
        this.status=status;
        this.data=data;
        this.error=error;
    }



}