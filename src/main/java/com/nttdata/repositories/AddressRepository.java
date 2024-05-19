package com.nttdata.repositories;

import com.nttdata.entities.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class AddressRepository {
    private final EntityManagerFactory emf;

    public AddressRepository() {
        this.emf = Persistence.createEntityManagerFactory("cv_test_pu");
    }

    public AddressRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
    }

    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public Address add(Address address) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            return address;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public Address update(Address address) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            address = entityManager.merge(address);
            entityManager.getTransaction().commit();
            return address;
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public Address findById(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.find(Address.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            Address address = entityManager.find(Address.class, id);
            if (address != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(address);
                entityManager.getTransaction().commit();
            }
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void close() {
        if (this.emf.isOpen()) {
            this.emf.close();
        }
    }
}
