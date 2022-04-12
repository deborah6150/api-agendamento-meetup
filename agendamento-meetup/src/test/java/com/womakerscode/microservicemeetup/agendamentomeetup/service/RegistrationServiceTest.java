package com.womakerscode.microservicemeetup.agendamentomeetup.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;
import com.womakerscode.microservicemeetup.agendamentomeetup.repository.RegistrationRepository;


public class RegistrationServiceTest {

	private RegistrationRepository mockRegistrationRepository = Mockito.mock(RegistrationRepository.class);

	@Autowired
    private RegistrationService registrationService;
	
	@Test
	@DisplayName("cadastraRegistration - Sucesso")
	public void createRegistrationTest() {
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro("10/04/2022");
		registration.setRegistration("001");
		
		Mockito.when(mockRegistrationRepository.save(registration)).thenReturn(registration);
		assertEquals("Deborah", registration.getNome());
		assertEquals(1L, registration.getId());
		assertNotNull(registration.getId());
		assertNotNull(registration);	
		
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
		assertEquals(2, registrationList.size() );
		assertEquals(registration, registrationList.get(0));
		assertEquals(registration2, registrationList.get(1));
			
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
		assertEquals(1L, registration.getId());
		
	}
	
    
}
