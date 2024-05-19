package com.nttdata.repositories;

import java.util.List;

import com.nttdata.entities.Client;
import com.nttdata.entities.Country;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CountryRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public CountryRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public CountryRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Country add(Country country) {
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        return country;
    }

    public Country update(Country country) {
        entityManager.getTransaction().begin();
        country = entityManager.merge(country);
        entityManager.getTransaction().commit();
        return country;
    }

    public Country findById(int id) {
        return entityManager.find(Country.class, id);
    }

    public void delete(Country country) {
        entityManager.getTransaction().begin();
        entityManager.remove(country);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
