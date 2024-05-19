package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.entities.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

}
