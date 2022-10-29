package com.themchoisebackend.themchoisebackend.models.portfolio;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="education")

public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String academy;

    private String title;

    private Integer year_start;
    private Integer year_end;
    private String description;

    public Education(){}

    public Education(Long id, String academy,String title, Integer year_start, Integer year_end, String description){

        this.id=id;
        this.academy=academy;
        this.title=title;
        this.year_start=year_start;
        this.year_end=year_end;
        this.description=description;
    }



}
