package com.nttdata.repositories;

import com.nttdata.entities.Degree;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DegreeRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public DegreeRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public DegreeRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Degree add(Degree degree) {
        entityManager.getTransaction().begin();
        entityManager.persist(degree);
        entityManager.getTransaction().commit();
        return degree;
    }

    public Degree update(Degree degree) {
        entityManager.getTransaction().begin();
        degree = entityManager.merge(degree);
        entityManager.getTransaction().commit();
        return degree;
    }

    public Degree findById(int id) {
        return entityManager.find(Degree.class, id);
    }

    public void delete(Degree degree) {
        entityManager.getTransaction().begin();
        entityManager.remove(degree);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
