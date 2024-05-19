package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {

}
