package com.themchoisebackend.themchoisebackend.interfaces.portfolio;
import com.themchoisebackend.themchoisebackend.models.portfolio.Person;

import java.util.List;

public interface IPersonDataService {

    public List<Person> verDatos();

     public void editAboutMe(Person per);


}
