package com.nttdata.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nttdata.entities.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class ClientRepository {
    @PersistenceContext(unitName = "cv_test_pu")
    private EntityManager entityManager;

    @Transactional
    public Client save(Client client) {
        entityManager.persist(client);
        entityManager.flush();
        return client;

    }

    public List<Client> findAll() {
        Query query = entityManager.createQuery("FROM Client", Client.class);
        return query.getResultList();
    }

    @Transactional
    public void update(Client client) {
        entityManager.merge(client);
    }

    public Client findById(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Transactional
    public void delete(Client client) {
        Client clientToRemove = findById(client.getId());
        if (clientToRemove != null) {
            entityManager.remove(entityManager.merge(client));
        }
    }

}
