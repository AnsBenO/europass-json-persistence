package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
