package com.nttdata.repositories;

import com.nttdata.entities.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AddressRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public AddressRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public AddressRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Address add(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    public Address update(Address address) {
        entityManager.getTransaction().begin();
        address = entityManager.merge(address);
        entityManager.getTransaction().commit();
        return address;
    }

    public Address findById(int id) {
        return entityManager.find(Address.class, id);
    }

    public void delete(Address address) {
        entityManager.getTransaction().begin();
        entityManager.remove(address);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
