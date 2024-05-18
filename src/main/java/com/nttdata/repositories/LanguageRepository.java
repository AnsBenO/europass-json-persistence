package com.nttdata.repositories;

import com.nttdata.entities.Language;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LanguageRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public LanguageRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public LanguageRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Language add(Language language) {
        entityManager.getTransaction().begin();
        entityManager.persist(language);
        entityManager.getTransaction().commit();
        return language;
    }

    public Language update(Language language) {
        entityManager.getTransaction().begin();
        language = entityManager.merge(language);
        entityManager.getTransaction().commit();
        return language;
    }

    public Language findById(int id) {
        return entityManager.find(Language.class, id);
    }

    public void delete(Language language) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(language) ? language : entityManager.merge(language));
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
