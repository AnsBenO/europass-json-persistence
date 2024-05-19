package com.nttdata.repositories;

import org.springframework.stereotype.Repository;

import com.nttdata.entities.Address;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class AddressRepository {

    @PersistenceContext(unitName = "cv_test_pu")
    private EntityManager entityManager;

    @Transactional
    public Address save(Address address) {
        entityManager.persist(address);
        entityManager.flush();
        return address;

    }

    @Transactional
    public Address update(Address address) {

        address = entityManager.merge(address);
        return address;
    }

    public Address findById(Long id) {

        return entityManager.find(Address.class, id);

    }

    @Transactional
    public void delete(Long id) {

        Address address = entityManager.find(Address.class, id);
        if (address != null) {
            entityManager.remove(address);
        }
    }

}
