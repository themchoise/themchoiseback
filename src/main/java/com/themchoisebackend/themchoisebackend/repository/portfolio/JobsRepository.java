package com.themchoisebackend.themchoisebackend.repository.portfolio;
import com.themchoisebackend.themchoisebackend.models.portfolio.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Long>  {
}
