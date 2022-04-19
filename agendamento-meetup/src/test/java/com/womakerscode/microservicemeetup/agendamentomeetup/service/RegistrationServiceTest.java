package com.womakerscode.microservicemeetup.agendamentomeetup.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.womakerscode.microservicemeetup.agendamentomeetup.exception.BadRequestException;
import com.womakerscode.microservicemeetup.agendamentomeetup.exception.EntityNotFoundException;
import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;
import com.womakerscode.microservicemeetup.agendamentomeetup.repository.RegistrationRepository;
import com.womakerscode.microservicemeetup.agendamentomeetup.service.impl.RegistrationServiceImpl;


public class RegistrationServiceTest {

	private RegistrationRepository mockRegistrationRepository = Mockito.mock(RegistrationRepository.class);
	
	private RegistrationServiceImpl registrationService = new RegistrationServiceImpl(mockRegistrationRepository);
	@Test
	@DisplayName("cadastraRegistration - Sucesso")
	public void createRegistrationTest() {
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro("10/04/2022");
		registration.setRegistration("001");
		
		Mockito.when(mockRegistrationRepository.save((Registration) any())).thenReturn(registration);
		Registration registr = registrationService.createRegistration(registration);
		assertEquals("Deborah", registr.getNome());
		assertEquals(1L, registr.getId());
		assertNotNull(registr.getId());
		assertNotNull(registr);	
		
	}
	
	@Test
	@DisplayName("buscaTodosRegistration - Sucesso")
	public void getAllRegistrationTest() {
		
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro("10/04/2022");
		registration.setRegistration("001");
		
		Registration registration2 = new Registration();
		registration2.setId(1L);
		registration2.setNome("nome2");
		registration2.setDataDoRegistro("10/04/2022");
		registration2.setRegistration("002");
		
		List<Registration> registrationList = new ArrayList<>();
		registrationList.add(registration);
		registrationList.add(registration2);
		
		Mockito.when(mockRegistrationRepository.findAll()).thenReturn(registrationList);
		
		List<Registration> list = registrationService.getAllRegistrations();
		assertEquals(2, list.size());
		assertSame(registrationList, list);
			
	}
	
	@Test
	@DisplayName("buscaRegistrationByID - Sucesso")
	public void getByIdRegistrationTest() {
		
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro("10/04/2022");
		registration.setRegistration("001");
		
		Mockito.when(mockRegistrationRepository.findById(1L)).thenReturn(Optional.of(registration));
		
		Registration registr = registrationService.getRegistrationById(registration.getId());
		
		assertEquals(1L, registr.getId());
		assertEquals("Deborah", registrationService.getRegistrationById(registr.getId()).getNome());
		assertEquals(1L, registrationService.getRegistrationById(registration.getId()).getId());
		
	}
	
	@Test
	@DisplayName("buscaRegistrationNotById - Exception")
	public void getByIdInexistenteRegistrationTest() {
		Mockito.when(mockRegistrationRepository.findById((Long) any())).thenReturn(Optional.<Registration>empty());
		assertThrows(EntityNotFoundException.class, () -> registrationService.getRegistrationById(100000L));
		verify(mockRegistrationRepository).findById((Long) any());

	}
	
	@Test
	@DisplayName("editarRegistration - Sucesso")
	public void editRegistrationTest() {
		
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro("10/04/2022");
		registration.setRegistration("001");
		Optional<Registration> ofResult = Optional.<Registration>of(registration);
		
		Registration registration2 = new Registration();
		registration2.setId(1L);
		registration2.setNome("Deborah Caroline");
		registration2.setDataDoRegistro("10/04/2022");
		registration2.setRegistration("0001");
		
		Mockito.when(mockRegistrationRepository.save((Registration) any())).thenReturn(registration2);
		Mockito.when(mockRegistrationRepository.findById((Long) any())).thenReturn(ofResult);
		
		assertSame(registration2, registrationService.editRegistration(1L, new Registration()));
		
	}
	
	@Test
	@DisplayName("editarRegistrationIdInexistente - Exception")
	public void editRegistrationIdInexistenteTest() {
		
		Mockito.when(mockRegistrationRepository.findById((Long) any())).thenReturn(Optional.<Registration>empty());
		assertThrows(BadRequestException.class, () -> registrationService.editRegistration(1000L, new Registration()));
		verify(mockRegistrationRepository).findById((Long) any());	
	}
	@Test
	@DisplayName("deletarRegistration - Sucesso")
	public void deleteRegistrationTest() {
		
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro("10/04/2022");
		registration.setRegistration("001");
		
		Mockito.when(mockRegistrationRepository.findById(1L)).thenReturn(Optional.of(registration));
		Object registr = registrationService.deleteRegistration(1L);
		Mockito.verify(mockRegistrationRepository, Mockito.times(1)).deleteById(registration.getId());
		
	}
	
	@Test
	@DisplayName("deletarRegistrationIdInexistente - Exception")
	public void deleteRegistrationIdInexistenteTest() {
		
		Mockito.when(mockRegistrationRepository.findById((Long) any())).thenReturn(Optional.<Registration>empty());
		assertThrows(BadRequestException.class, () -> registrationService.deleteRegistration(1000L));
		verify(mockRegistrationRepository).findById((Long) any());	
		
	}
    
}
