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
import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;
import com.womakerscode.microservicemeetup.agendamentomeetup.repository.RegistrationRepository;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationRepository repository;
	

	public RegistrationServiceImpl(RegistrationRepository repository) {
		this.repository = repository;
	}
	

	@Override
	public Registration createRegistration(Registration registration) {
		if(repository.existsByRegistration(registration.getRegistration())) {
			throw new BusinessException("Cadastro já criado");
		}
		return repository.save(registration);
	}

	@Override
	public List<Registration> getAllRegistrations() {
		return repository.findAll();
	}

	@Override
	public Registration getRegistrationById(Long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cadastro não encontrado"));
	}

//	@Override
//	public Registration editRegistration(Long id, Registration registration) {
////		repository.findById(id).ifPresent(consume -> {
////			throw new BadRequestException ("Cliente não encontrado para o ID:" + id);
////		});		
//		repository.findByRegistration(registration.getRegistration()).ifPresent(consume -> {
//			throw new BadRequestException("Já existe um Cadastro com este registration.");
//		});
//		return repository.save(registration);
//	}
	
	@Override
	public Registration editRegistration(Long id, Registration registration) {
		Optional<Registration> regist = repository.findById(id);
		Registration novosDadosRegistration = null;
		
		if(regist.isPresent()) {
			novosDadosRegistration = regist.get();
			
			novosDadosRegistration.setNome(registration.getNome());
			novosDadosRegistration.setDataDoRegistro(registration.getDataDoRegistro());
			novosDadosRegistration.setRegistration(registration.getRegistration());
			
			novosDadosRegistration = repository.save(novosDadosRegistration);
		}
		else {
			throw new BadRequestException ("Cliente não encontrado para o ID:" + id);
		}
		return novosDadosRegistration;
	}
	

	@Override
	public Object deleteRegistration(Long id) {
		if (repository.findById(id).isEmpty())
            throw new BadRequestException ("Cliente não encontrado para o ID:" + id);
    	
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK);
		
	}
	
	@Override
    public Registration getRegistrationByRegistrationAttribute(String registrationAttribute) {
        return repository.findByRegistration(registrationAttribute)
        		.orElseThrow(() -> new EntityNotFoundException("Cadastro não encontrado"));
    }
	
	
	
}
