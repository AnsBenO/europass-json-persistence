package com.nttdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/**
 * This class configures the application by defining the necessary beans for
 * Spring to manage
 * transactions and access to the database using JPA. It also specifies the
 * packages where
 * the repository interfaces are located.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nttdata.repositories")
@ComponentScan("com.nttdata")
public class TestConfig {

    /**
     * This method creates a LocalEntityManagerFactoryBean bean which is used to
     * create an
     * EntityManagerFactory. The EntityManagerFactory is used to create
     * EntityManager instances
     * which are used to interact with the database.
     *
     * @return the created LocalEntityManagerFactoryBean
     */
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("cv_test_pu");
        return factoryBean;
    }

    /**
     * This method creates a JpaTransactionManager bean which is used to manage
     * transactions
     * for the EntityManagerFactory. The EntityManagerFactory is obtained from the
     * provided
     * EntityManagerFactory object.
     *
     * @param emf the EntityManagerFactory to be used by the JpaTransactionManager
     * @return the created JpaTransactionManager
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
