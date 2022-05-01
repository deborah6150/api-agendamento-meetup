package com.womakerscode.microservicemeetup.agendamentomeetup.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.womakerscode.microservicemeetup.agendamentomeetup.exception.BadRequestException;
import com.womakerscode.microservicemeetup.agendamentomeetup.exception.EntityNotFoundException;
import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;
import com.womakerscode.microservicemeetup.agendamentomeetup.repository.MeetupRepository;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.impl.MeetupServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MeetupServiceTest {

private MeetupService meetupService;
	
	@MockBean
	private MeetupRepository mockMeetupRepository;
	
	@BeforeEach
    public void setUp() {
        this.meetupService = new MeetupServiceImpl(mockMeetupRepository);
    }
	
	@Test
	@DisplayName("cadastraMeetup - Sucesso")
	public void createMeetupTest() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date("21/05/2024"));
		
		Mockito.when(mockMeetupRepository.save((Meetup) any())).thenReturn(meetup);
		Meetup meet = meetupService.createMeetup(meetup);
		assertEquals("Curso de Java", meet.getEvento());
		assertEquals(1L, meet.getId());
		assertNotNull(meet.getId());
		assertNotNull(meet);
		
	}
	
	@Test
	@DisplayName("buscaTodosMeetups - Sucesso")
	public void getAllMeetupTest() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21-05-2024));
		
		Meetup meetup2 = new Meetup();
		meetup2.setId(2L);
		meetup2.setEvento("Curso de Python");
		meetup2.setLocal("Rua zero 5000");
		meetup.setDataMeetup(new Date(22-02-2025));
		
		
		List<Meetup> meetupList = new ArrayList<>();
		meetupList.add(meetup);
		meetupList.add(meetup2);
		
		Mockito.when(mockMeetupRepository.findAll()).thenReturn(meetupList);
		
		List<Meetup> list = meetupService.getAllMeetups();
		assertEquals(2, list.size());
		assertSame(meetupList, list);
			
	}
	
	@Test
	@DisplayName("buscaMeetupByID - Sucesso")
	public void getByIdMeetupTest() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21-05-2024));
		
		Mockito.when(mockMeetupRepository.findById(1L)).thenReturn(Optional.of(meetup));
		
		Meetup meet = meetupService.getMeetupById(meetup.getId());
		
		assertEquals(1L, meet.getId());
		assertEquals("Curso de Java", meetupService.getMeetupById(meet.getId()).getEvento());
		assertEquals(1L, meetupService.getMeetupById(meetup.getId()).getId());
		
	}
	
	@Test
	@DisplayName("buscaMeetupNotById - Exception")
	public void getByIdInexistenteMeetupTest() {
		Mockito.when(mockMeetupRepository.findById((Long) any())).thenReturn(Optional.<Meetup>empty());
		assertThrows(EntityNotFoundException.class, () -> meetupService.getMeetupById(100000L));
		verify(mockMeetupRepository).findById((Long) any());

	}
	
	@Test
	@DisplayName("editarMeetup - Sucesso")
	public void editMeetupTest() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21-05-2024));
		Optional<Meetup> ofResult = Optional.<Meetup>of(meetup);
		
		Meetup meetup2 = new Meetup();
		meetup2.setId(2L);
		meetup2.setEvento("Curso de Python");
		meetup2.setLocal("Rua zero 5000");
		meetup.setDataMeetup(new Date(22-02-2025));
		
		Mockito.when(mockMeetupRepository.save((Meetup) any())).thenReturn(meetup2);
		Mockito.when(mockMeetupRepository.findById((Long) any())).thenReturn(ofResult);
		
		assertSame(meetup2, meetupService.editMeetup(1L, new Meetup()));
		
	}
	
	@Test
	@DisplayName("editarMeetupIdInexistente - Exception")
	public void editMeetupIdInexistenteTest() {
		
		Mockito.when(mockMeetupRepository.findById((Long) any())).thenReturn(Optional.<Meetup>empty());
		assertThrows(BadRequestException.class, () -> meetupService.editMeetup(1000L, new Meetup()));
		verify(mockMeetupRepository).findById((Long) any());	
	}
	@Test
	@DisplayName("deletarMeetup - Sucesso")
	public void deleteMeetupTest() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21-05-2024));
		
		Mockito.when(mockMeetupRepository.findById(1L)).thenReturn(Optional.of(meetup));
		Object meet = meetupService.deleteMeetup(1L);
		Mockito.verify(mockMeetupRepository, Mockito.times(1)).deleteById(meetup.getId());
		
	}
	
	@Test
	@DisplayName("deletarMeetupIdInexistente - Exception")
	public void deleteMeetupIdInexistenteTest() {
		
		Mockito.when(mockMeetupRepository.findById((Long) any())).thenReturn(Optional.<Meetup>empty());
		assertThrows(BadRequestException.class, () -> meetupService.deleteMeetup(1000L));
		verify(mockMeetupRepository).findById((Long) any());	
		
	}
	
}
