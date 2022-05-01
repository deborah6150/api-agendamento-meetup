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

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.MeetupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/meetup")
@Api(value="API REST Meetup")
@CrossOrigin(origins = "*")
public class MeetupController {
	
	@Autowired
	MeetupService meetupService;
	
	@GetMapping("/")
	@ApiOperation(value = "Lista todos os meetups cadastrados.")
	public List<Meetup> getMeetup() {
		return meetupService.getAllMeetups();
	}
	
	@GetMapping("/{id}/")
	@ApiOperation(value = "Retorna meetup específico através do id.")
	public Meetup getMeetupById(@PathVariable(required = true) Long id) {
		return meetupService.getMeetupById(id);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Cadastra um meetup.")
	public ResponseEntity<Meetup> createMeetup(@RequestBody Meetup meetup) {
		return new ResponseEntity<Meetup>(meetupService.createMeetup(meetup), HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}/")
	@ApiOperation(value = "Atualiza informações de um meetup.")
	public Meetup editMeetup(@PathVariable(required = true) Long id, @RequestBody Meetup meetup) {
		return meetupService.editMeetup(id, meetup);
	}
	
	@DeleteMapping("/{id}/")
	@ApiOperation(value = "Deleta um meetup cadastrado.")
	public ResponseEntity<String> deleteMeetup(@PathVariable(required = true) Long id) {
		meetupService.deleteMeetup(id);
		return new ResponseEntity<String>("Cadastro excluído com sucesso.", HttpStatus.OK);
	}
	

}
