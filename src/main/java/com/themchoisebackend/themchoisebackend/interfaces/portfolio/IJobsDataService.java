package com.themchoisebackend.themchoisebackend.interfaces.portfolio;
import com.themchoisebackend.themchoisebackend.models.portfolio.Jobs;

import java.util.List;

public interface IJobsDataService {
    public List<Jobs> verDatos();

    public void editJobs(Jobs job);
    public void removeJobs(Jobs job);


}


