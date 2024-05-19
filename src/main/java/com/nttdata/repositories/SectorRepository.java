package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {

}
