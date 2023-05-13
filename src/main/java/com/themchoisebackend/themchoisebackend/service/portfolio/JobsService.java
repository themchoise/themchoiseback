package com.themchoisebackend.themchoisebackend.service.portfolio;
import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IJobsDataService;
import com.themchoisebackend.themchoisebackend.models.portfolio.Jobs;
import com.themchoisebackend.themchoisebackend.repository.portfolio.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class JobsService implements IJobsDataService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public JobsRepository jobsRepo;

    @Override
    public List<Jobs> verDatos() {
        return jobsRepo.findAll();
    }

    @Override
    public void editJobs(Jobs job) {jobsRepo.save(job); }

    @Override
    public void removeJobs(Jobs job) {jobsRepo.delete(job); }


}



