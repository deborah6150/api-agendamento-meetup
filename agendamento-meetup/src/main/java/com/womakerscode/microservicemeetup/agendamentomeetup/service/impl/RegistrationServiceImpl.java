package com.womakerscode.microservicemeetup.agendamentomeetup.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.womakerscode.microservicemeetup.agendamentomeetup.exception.BadRequestException;
import com.womakerscode.microservicemeetup.agendamentomeetup.exception.BusinessException;
import com.womakerscode.microservicemeetup.agendamentomeetup.exception.EntityNotFoundException;
import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;
import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;
import com.womakerscode.microservicemeetup.agendamentomeetup.repository.RegistrationRepository;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.MeetupService;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationRepository repository;
	
	@Autowired
	MeetupService meetupService;

	public RegistrationServiceImpl(RegistrationRepository repository, MeetupService meetupService) {
		this.repository = repository;
		this.meetupService = meetupService;
	}
	

	@Override
	public Registration createRegistration(Long idMeetup, Registration registration) {
		if(repository.existsByMatricula(registration.getMatricula())) {
			throw new BusinessException("Registro já criado");
		}
		Meetup meetup = meetupService.getMeetupById(idMeetup);
		meetup.getListaRegistrations().add(registration);
		registration.setMeetup(meetup);
		return repository.save(registration);
	}

	@Override
	public List<Registration> getAllRegistrations() {
		return repository.findAll();
	}

	@Override
	public Registration getRegistrationById(Long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Registro não encontrado"));
	}
	
	@Override
	public Registration editRegistration(Long id, Registration registration) {
		Optional<Registration> regist = repository.findById(id);
		Registration novosDadosRegistration = null;
		
		if(regist.isPresent()) {
			novosDadosRegistration = regist.get();
			
			novosDadosRegistration.setNome(registration.getNome());
			novosDadosRegistration.setDataDoRegistro(registration.getDataDoRegistro());
			novosDadosRegistration.setMatricula(registration.getMatricula());
			
			novosDadosRegistration = repository.save(novosDadosRegistration);
		}
		else {
			throw new BadRequestException ("Registro não encontrado para o ID:" + id);
		}
		return novosDadosRegistration;
	}
	

	@Override
	public Object deleteRegistration(Long id) {
		if (repository.findById(id).isEmpty())
            throw new BadRequestException ("Registro não encontrado para o ID:" + id);
    	
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK);
		
	}
	
}
