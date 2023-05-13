package com.themchoisebackend.themchoisebackend.controllers.portfolio;

import com.themchoisebackend.themchoisebackend.helper.ValidateToken;
import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IJobsDataService;
import com.themchoisebackend.themchoisebackend.models.Data;
import com.themchoisebackend.themchoisebackend.models.portfolio.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class JobsController {

    @Autowired
    private IJobsDataService jobsDataService;
    @Autowired
    private ValidateToken valtok;

    @PutMapping("/edit/kingKongJobs")
    @ResponseBody

    public Data editJobs(@RequestHeader(value="Authorization")String token, @RequestBody Jobs job)  throws ClassNotFoundException {



        if ( !valtok.validate(token) ){
            return new Data(false, null, "Error Indefinido");
        }


        try {
            jobsDataService.editJobs(job);
            return new Data(true, null, null);
        }catch (Exception  ex){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parametros Invalidos");
        }

    }
    @PutMapping("/remove/kingKongJobs")
    @ResponseBody
    public Data removeJobs(@RequestHeader(value="Authorization")String token, @RequestBody Jobs job)  throws ClassNotFoundException {

        if ( !valtok.validate(token) ){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parametros Invalidos");
        }

        try {
            jobsDataService.removeJobs(job);
            return new Data(true, null, null);
        }catch (Exception  ex){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parametros Invalidos");
        }

    }

    @GetMapping("/jobs/listJobs")
    @ResponseBody
    public List<Jobs> verPortFolioDatos(){
        return jobsDataService.verDatos();
    }


}
