package com.themchoisebackend.themchoisebackend.repository.portfolio;
import com.themchoisebackend.themchoisebackend.models.portfolio.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonDataRepository extends  JpaRepository<Person, Long> {
}

