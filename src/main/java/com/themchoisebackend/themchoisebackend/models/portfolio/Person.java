package com.themchoisebackend.themchoisebackend.models.portfolio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nombre;
    private String apellido;
    private String about_me;

    public Person(){}

    public Person(Long id, String nombre, String apellido, String about_me){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.about_me=about_me;
    }
}
