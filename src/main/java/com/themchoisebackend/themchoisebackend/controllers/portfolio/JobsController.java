package com.themchoisebackend.themchoisebackend.controllers.portfolio;

import com.themchoisebackend.themchoisebackend.helper.ValidateToken;
import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IJobsDataService;
import com.themchoisebackend.themchoisebackend.models.Data;
import com.themchoisebackend.themchoisebackend.models.portfolio.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobsController {

    @Autowired
    private IJobsDataService jobsDataService;
    @Autowired
    private ValidateToken valtok;

    @PutMapping("/edit/kingKongJobs")
    @ResponseBody
    public Data editAboutMe(@RequestHeader(value="Authorization")String token, @RequestBody Jobs job)  throws ClassNotFoundException {

        System.out.println(token);

        if ( !valtok.validate(token) ){
            return new Data(false, null, "Error Indefinido");
        }

        try {
            jobsDataService.editJobs(job);
            return new Data(true, null, null);
        }catch (Exception  ex){
            return new Data(false, null, "Error al editar Jobs, pollo que estas haciendo ?");
        }

    }

    @GetMapping("/jobs/listJobs")
    @ResponseBody
    public List<Jobs> verPortFolioDatos(){
        return jobsDataService.verDatos();
    }


}
