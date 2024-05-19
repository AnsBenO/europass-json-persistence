package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
