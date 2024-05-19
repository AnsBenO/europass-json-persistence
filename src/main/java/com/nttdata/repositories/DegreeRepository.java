package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Long> {

}
