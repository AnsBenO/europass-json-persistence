package com.nttdata.repositories;

import com.nttdata.entities.Skill;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SkillRepository {
    private final EntityManager entityManager;
    private final EntityManagerFactory emf;

    public SkillRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public SkillRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Skill add(Skill skill) {
        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();
        return skill;
    }

    public Skill update(Skill skill) {
        entityManager.getTransaction().begin();
        skill = entityManager.merge(skill);
        entityManager.getTransaction().commit();
        return skill;
    }

    public Skill findById(int id) {
        return entityManager.find(Skill.class, id);
    }

    public void delete(Skill skill) {
        entityManager.getTransaction().begin();
        entityManager.remove(skill);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
