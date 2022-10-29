package com.themchoisebackend.themchoisebackend.controllers.portfolio;
import com.themchoisebackend.themchoisebackend.helper.ValidateToken;
import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IEducationService;
import com.themchoisebackend.themchoisebackend.models.Data;
import com.themchoisebackend.themchoisebackend.models.portfolio.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationController {

        @Autowired
        private IEducationService educationService;
        private ValidateToken valtok;

        @GetMapping("/education/listEducation")
        @ResponseBody
        public List<Education> verDatosEducacion(){
            return educationService.verDatos();
        }


    @PutMapping("/edit/education")
    @ResponseBody
    public Data editEducation(@RequestHeader(value="Authorization")String token, @RequestBody Education educ)  throws ClassNotFoundException {
            System.out.println(token);

            if ( !valtok.validate(token) ){

                return new Data(false, null, "Error Indefinido");
            }

        try {
            educationService.editEducation(educ);
            return new Data(true, null, null);
        }catch (Exception  ex){
            return new Data(false, null, "Error al editar Jobs, pollo que estas haciendo ?");
        }

    }

    }

