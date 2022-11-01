
package com.themchoisebackend.themchoisebackend.service.portfolio;
import com.themchoisebackend.themchoisebackend.interfaces.portfolio.IPersonDataService;
import com.themchoisebackend.themchoisebackend.models.portfolio.Person;
import com.themchoisebackend.themchoisebackend.repository.portfolio.PersonDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PortFolioData implements IPersonDataService {

        @PersistenceContext
        private EntityManager entityManager;

       @Autowired
        public PersonDataRepository portFolioRepo;

        @Override
        public List<Person> verDatos() {

                return portFolioRepo.findAll();
        }

        @Override
        public void editAboutMe(Person per) {
                portFolioRepo.save(per);


        }
}
