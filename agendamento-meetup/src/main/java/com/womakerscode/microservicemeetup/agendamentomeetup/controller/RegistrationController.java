package com.womakerscode.microservicemeetup.agendamentomeetup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.RegistrationService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	@GetMapping("/")
	public List<Registration> getRegistrations() {
		return registrationService.getAllRegistrations();
	}
	
	@GetMapping("/{id}/")
	public Registration getRegistrationById(@PathVariable(required = true) Long id) {
		return registrationService.getRegistrationById(id);
	}
	
	@PostMapping("/{idMeetup}/")
	public ResponseEntity<Registration> createRegistration(@PathVariable(required = true) Long idMeetup, @RequestBody Registration registration) {
		return new ResponseEntity<Registration>(registrationService.createRegistration(idMeetup, registration), HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}/")
	public Registration editRegistration(@PathVariable(required = true) Long id, @RequestBody Registration registration) {
		return registrationService.editRegistration(id, registration);
	}
	
	@DeleteMapping("/{id}/")
	public ResponseEntity<String> deleteRegistration(@PathVariable(required = true) Long id) {
		registrationService.deleteRegistration(id);
		return new ResponseEntity<String>("Cadastro excluído com sucesso.", HttpStatus.OK);
	}
	
	
	
	
	
	
}
