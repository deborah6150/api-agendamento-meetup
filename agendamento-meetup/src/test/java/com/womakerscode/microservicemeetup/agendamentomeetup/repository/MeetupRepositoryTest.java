package com.womakerscode.microservicemeetup.agendamentomeetup.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class MeetupRepositoryTest {

	@Autowired
	MeetupRepository repository;
	
	@Test
	@DisplayName("cadastraMeetup - Sucesso")
	public void createMeetup() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21-05-2024));
		
		Meetup meetupSaved = repository.save(meetup);
		
		Assertions.assertThat(meetupSaved).isNotNull();
		Assertions.assertThat(meetupSaved.getId()).isNotNull();
		Assertions.assertThat(meetupSaved.getEvento()).isEqualTo(meetup.getEvento());
	}
	
	@Test
    @DisplayName("buscaTodosMeetup - Sucesso")
    public void findAllMeetup(){
				
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21/05/2024));
		
		Meetup meetupSave = repository.save(meetup);
		List<Meetup> meetupList = repository.findAll();
		
		Assertions.assertThat(meetupList).isNotEmpty();
		Assertions.assertThat(meetupList).contains(meetupSave);

    }
	
	@Test
	@DisplayName("editarMeetup - Sucesso")
	public void editMeetupTest() {
		
		Meetup meetup1 = new Meetup();
		meetup1.setId(1L);
		meetup1.setEvento("Curso de Java");
		meetup1.setLocal("Rua getulio vargas 5000");
		meetup1.setDataMeetup(new Date(21/05/2024));
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21/05/2024));
		
		Meetup meetupSaved = repository.save(meetup1);
		Assertions.assertThat(meetupSaved).isNotNull();
        Assertions.assertThat(meetupSaved.getId()).isNotNull();
        Assertions.assertThat(meetupSaved.getEvento()).isEqualTo(meetup1.getEvento());
		
	}
	
	@Test
	@DisplayName("deletarMeetup - Sucesso")
	public void deleteMeetupTest() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21/05/2024));
		
		Meetup meetupSaved = repository.save(meetup);
		repository.delete(meetupSaved);
		
		Optional<Meetup> meetupOptional = repository.findById(meetupSaved.getId());
		
		Assertions.assertThat(meetupOptional).isEmpty();
		
	}
	
	@Test
	@DisplayName("buscaMeetupByID - Sucesso")
	public void getByIdMeetupTest() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21/05/2024));
		
		Meetup meetupSaved = repository.save(meetup);
		
		Optional<Meetup> meetupID = repository.findById(meetupSaved.getId());
		
		Assertions.assertThat(meetupID).isNotEmpty();
        Assertions.assertThat(meetupID).contains(meetupSaved);
		
	}
}
