package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
