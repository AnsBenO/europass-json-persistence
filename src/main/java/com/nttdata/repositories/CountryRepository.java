package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
