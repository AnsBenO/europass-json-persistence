package com.nttdata.repositories;

import com.nttdata.entities.City;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CityRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public CityRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public CityRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public City add(City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        return city;
    }

    public City update(City city) {
        entityManager.getTransaction().begin();
        city = entityManager.merge(city);
        entityManager.getTransaction().commit();
        return city;
    }

    public City findById(int id) {
        return entityManager.find(City.class, id);
    }

    public void delete(City city) {
        entityManager.getTransaction().begin();
        entityManager.remove(city);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
