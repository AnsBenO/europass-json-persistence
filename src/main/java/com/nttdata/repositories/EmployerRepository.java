package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

}
