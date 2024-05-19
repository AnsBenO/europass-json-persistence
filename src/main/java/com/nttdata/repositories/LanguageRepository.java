package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}