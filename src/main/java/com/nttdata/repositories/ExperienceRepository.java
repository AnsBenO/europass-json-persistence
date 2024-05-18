package com.nttdata.repositories;

import com.nttdata.entities.Experience;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ExperienceRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public ExperienceRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public ExperienceRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Experience add(Experience experience) {
        entityManager.getTransaction().begin();
        entityManager.persist(experience);
        entityManager.getTransaction().commit();
        return experience;
    }

    public Experience update(Experience experience) {
        entityManager.getTransaction().begin();
        experience = entityManager.merge(experience);
        entityManager.getTransaction().commit();
        return experience;
    }

    public Experience findById(int id) {
        return entityManager.find(Experience.class, id);
    }

    public void delete(Experience experience) {
        entityManager.getTransaction().begin();
        entityManager.remove(experience);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
