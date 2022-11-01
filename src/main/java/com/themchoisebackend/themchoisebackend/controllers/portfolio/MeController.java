package com.themchoisebackend.themchoisebackend.controllers.portfolio;
import com.themchoisebackend.themchoisebackend.helper.ValidateToken;
import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IPersonDataService;
import com.themchoisebackend.themchoisebackend.models.Data;
import com.themchoisebackend.themchoisebackend.models.portfolio.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeController {


    @Autowired
    private IPersonDataService personDataService;

    @Autowired
    private ValidateToken valtok;

    // La controladora va a estar conectada al servicio
    // el servicio al repo
    // el repo se conecta a la db

    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/ver/portFolioData")
    @ResponseBody
    public List<Person> verPortFolioDatos(){
        return personDataService.verDatos();
    }


    @PutMapping("/edit/portFolioData")
    @ResponseBody
    public Data editAboutMe(@RequestHeader(value="Authorization")String token, @RequestBody Person pers)  throws ClassNotFoundException {

        if ( !valtok.validate(token) ){
            return new Data(false, null, "Error Indefinido");
        }

    try {
        personDataService.editAboutMe(pers);
        return new Data(true, null, null);
    }catch (Exception  ex){
          return new Data(false, null, "Error in Save About");
    }


    }


}
