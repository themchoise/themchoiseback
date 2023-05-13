package com.themchoisebackend.themchoisebackend.service.portfolio;
import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IEducationService;
import com.themchoisebackend.themchoisebackend.models.portfolio.Education;
import com.themchoisebackend.themchoisebackend.repository.portfolio.EducationRepostiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EducationService implements IEducationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public EducationRepostiroty educRepo;

    @Override
    public List<Education> verDatos() {
        return educRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public void editEducation(Education educ) {
        educRepo.save(educ);

    }

    public void removeEducation(Education educ) {
        educRepo.delete(educ);

    }

}




