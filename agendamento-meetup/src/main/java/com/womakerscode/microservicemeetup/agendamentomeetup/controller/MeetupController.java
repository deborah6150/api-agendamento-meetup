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

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.MeetupService;

@RestController
@RequestMapping("/api/meetup")
public class MeetupController {
	
	@Autowired
	MeetupService meetupService;
	
	@GetMapping("/")
	public List<Meetup> getMeetup() {
		return meetupService.getAllMeetups();
	}
	
	@GetMapping("/{id}/")
	public Meetup getMeetupById(@PathVariable(required = true) Long id) {
		return meetupService.getMeetupById(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<Meetup> createMeetup(@RequestBody Meetup meetup) {
		return new ResponseEntity<Meetup>(meetupService.createMeetup(meetup), HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}/")
	public Meetup editMeetup(@PathVariable(required = true) Long id, @RequestBody Meetup meetup) {
		return meetupService.editMeetup(id, meetup);
	}
	
	@DeleteMapping("/{id}/")
	public ResponseEntity<String> deleteMeetup(@PathVariable(required = true) Long id) {
		meetupService.deleteMeetup(id);
		return new ResponseEntity<String>("Cadastro excluído com sucesso.", HttpStatus.OK);
	}
	

}
