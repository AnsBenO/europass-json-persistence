package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
