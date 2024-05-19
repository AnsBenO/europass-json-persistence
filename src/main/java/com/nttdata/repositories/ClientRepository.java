package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}