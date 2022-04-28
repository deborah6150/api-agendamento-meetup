package com.womakerscode.microservicemeetup.agendamentomeetup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>{

	boolean existsByMatricula(String matricula);
}
