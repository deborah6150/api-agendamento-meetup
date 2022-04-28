package com.womakerscode.microservicemeetup.agendamentomeetup.service;

import java.util.List;

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;

public interface RegistrationService {

	Registration createRegistration(Long idMeetup, Registration registration);
	List<Registration> getAllRegistrations();
	Registration getRegistrationById(Long id);
	Registration editRegistration(Long id, Registration registration);
	Object deleteRegistration(Long id);
	
}
