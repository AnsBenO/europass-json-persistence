package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
