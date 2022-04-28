package com.womakerscode.microservicemeetup.agendamentomeetup.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.womakerscode.microservicemeetup.agendamentomeetup.exception.BadRequestException;
import com.womakerscode.microservicemeetup.agendamentomeetup.exception.EntityNotFoundException;
import com.womakerscode.microservicemeetup.agendamentomeetup.exception.PreviousDateException;
import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;
import com.womakerscode.microservicemeetup.agendamentomeetup.repository.MeetupRepository;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.MeetupService;

@Service
public class MeetupServiceImpl implements MeetupService{
	
	@Autowired
	MeetupRepository repository;

	public MeetupServiceImpl(MeetupRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public Meetup createMeetup(Meetup meetup) {
		verificaDatadoMeetup(meetup.getDataMeetup());
		return repository.save(meetup);
	}

	@Override
	public List<Meetup> getAllMeetups() {
		return repository.findAll();
	}

	@Override
	public Meetup getMeetupById(Long id) {
		return repository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException("Meetup não encontrado"));
	}

	@Override
	public Meetup editMeetup(Long id, Meetup meetup) {
		Optional<Meetup> meet = repository.findById(id);
		Meetup novosDadosMeetup = null;
		
		if(meet.isPresent()) {
			novosDadosMeetup = meet.get();
			
			novosDadosMeetup.setEvento(meetup.getEvento());
			novosDadosMeetup.setDataMeetup(meetup.getDataMeetup());
			novosDadosMeetup.setLocal(meetup.getLocal());
			
			novosDadosMeetup = repository.save(novosDadosMeetup);
		}
		else {
			throw new BadRequestException ("Meetup não encontrado para o ID:" + id);
		}
		return novosDadosMeetup;
	}

	@Override
	public Object deleteMeetup(Long id) {
		if (repository.findById(id).isEmpty())
            throw new BadRequestException ("Meetup não encontrado para o ID:" + id);
    	
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	private void verificaDatadoMeetup(Date dataMeetup) {
		
		Date dataAtual = new Date();
		if(dataMeetup.before(dataAtual)) {
			throw new PreviousDateException("Data invalida");
		}
		
	}
	
	
	
	
}
