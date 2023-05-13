package com.themchoisebackend.themchoisebackend.models.portfolio;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="jobs_portfolio")

public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String company;
    private String job_title;
    private String job_desc;
    private Integer year_start;
    private Integer year_end;

    public Jobs(){}

    public Jobs(Long id, String company, String job_title, String job_desc, Integer year_start, Integer year_end){
        this.id=id;
        this.company=job_title;
        this.job_desc=job_desc;
        this.year_start=year_start;
        this.year_end=year_end;
    }


    public long returnId() {
        return this.id;
    }
}
