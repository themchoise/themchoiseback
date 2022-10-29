package com.themchoisebackend.themchoisebackend.interfaces.portfolio;
import com.themchoisebackend.themchoisebackend.models.portfolio.Education;

import java.util.List;

public interface IEducationService {
    public List<Education> verDatos();

    public void editEducation(Education job);
}
