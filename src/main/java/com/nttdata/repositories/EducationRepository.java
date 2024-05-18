package com.nttdata.repositories;

import com.nttdata.entities.Education;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EducationRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public EducationRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public EducationRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Education add(Education education) {
        entityManager.getTransaction().begin();
        entityManager.persist(education);
        entityManager.getTransaction().commit();
        return education;
    }

    public Education update(Education education) {
        entityManager.getTransaction().begin();
        education = entityManager.merge(education);
        entityManager.getTransaction().commit();
        return education;
    }

    public Education findById(int id) {
        return entityManager.find(Education.class, id);
    }

    public void delete(Education education) {
        entityManager.getTransaction().begin();
        entityManager.remove(education);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
