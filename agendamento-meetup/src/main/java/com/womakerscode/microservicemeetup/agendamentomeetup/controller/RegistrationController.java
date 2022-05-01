package com.womakerscode.microservicemeetup.agendamentomeetup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/registration")
@Api(value="API REST Registration")
@CrossOrigin(origins = "*")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	@GetMapping("/")
	@ApiOperation(value = "Lista todos os registration cadastrados.")
	public List<Registration> getRegistrations() {
		return registrationService.getAllRegistrations();
	}
	
	@GetMapping("/{id}/")
	@ApiOperation(value = "Retorna registration específico através do id.")
	public Registration getRegistrationById(@PathVariable(required = true) Long id) {
		return registrationService.getRegistrationById(id);
	}
	
	@PostMapping("/{idMeetup}/")
	@ApiOperation(value = "Cadastra um registration.")
	public ResponseEntity<Registration> createRegistration(@PathVariable(required = true) Long idMeetup, @RequestBody Registration registration) {
		return new ResponseEntity<Registration>(registrationService.createRegistration(idMeetup, registration), HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}/")
	@ApiOperation(value = "Atualiza informações de um registration.")
	public Registration editRegistration(@PathVariable(required = true) Long id, @RequestBody Registration registration) {
		return registrationService.editRegistration(id, registration);
	}
	
	@DeleteMapping("/{id}/")
	@ApiOperation(value = "Deleta um registration cadastrado.")
	public ResponseEntity<String> deleteRegistration(@PathVariable(required = true) Long id) {
		registrationService.deleteRegistration(id);
		return new ResponseEntity<String>("Cadastro excluído com sucesso.", HttpStatus.OK);
	}
	
	
	
	
	
	
}
