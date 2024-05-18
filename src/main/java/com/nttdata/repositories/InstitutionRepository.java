package com.nttdata.repositories;

import com.nttdata.entities.Institution;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InstitutionRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public InstitutionRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public InstitutionRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Institution add(Institution institution) {
        entityManager.getTransaction().begin();
        entityManager.persist(institution);
        entityManager.getTransaction().commit();
        return institution;
    }

    public Institution update(Institution institution) {
        entityManager.getTransaction().begin();
        institution = entityManager.merge(institution);
        entityManager.getTransaction().commit();
        return institution;
    }

    public Institution findById(int id) {
        return entityManager.find(Institution.class, id);
    }

    public void delete(Institution institution) {
        entityManager.getTransaction().begin();
        entityManager.remove(institution);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
