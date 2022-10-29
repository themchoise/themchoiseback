package com.themchoisebackend.themchoisebackend.repository.portfolio;
import com.themchoisebackend.themchoisebackend.models.portfolio.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDataRepository extends  JpaRepository<Person, Long> {
}

