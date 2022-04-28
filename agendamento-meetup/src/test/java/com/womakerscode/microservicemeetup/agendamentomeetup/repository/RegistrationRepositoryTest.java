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
import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Registration;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class RegistrationRepositoryTest {

	@Autowired
	RegistrationRepository repository;
	
	@Test
	@DisplayName("cadastraRegistration - Sucesso")
	public void createRegistration() {
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21-05-2024));
		
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro(new Date());
		registration.setMatricula("001");
		
		Registration registrationSaved = repository.save(registration);
		
		Assertions.assertThat(registrationSaved).isNotNull();
		Assertions.assertThat(registrationSaved.getId()).isNotNull();
		Assertions.assertThat(registrationSaved.getNome()).isEqualTo(registration.getNome());
	}
	
	@Test
    @DisplayName("buscaTodosRegistration - Sucesso")
    public void findAllRegistration(){
				
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro(new Date());
		registration.setMatricula("001");
		
		Meetup meetup = new Meetup();
		meetup.setId(1L);
		meetup.setEvento("Curso de Java");
		meetup.setLocal("Rua getulio vargas 5000");
		meetup.setDataMeetup(new Date(21/05/2024));
		
		Registration registrationSave = repository.save(registration);
		List<Registration> registrationList = repository.findAll();
		
		Assertions.assertThat(registrationList).isNotEmpty();
		Assertions.assertThat(registrationList).contains(registrationSave);

    }
	
	@Test
	@DisplayName("editarRegistration - Sucesso")
	public void editRegistrationTest() {
		
		Registration registration1 = new Registration();
		registration1.setId(1L);
		registration1.setNome("Deborah");
		registration1.setDataDoRegistro(new Date());
		registration1.setMatricula("001");
		
		Registration registration2 = new Registration();
		registration2.setId(1L);
		registration2.setNome("Deborah Caroline");
		registration2.setDataDoRegistro(new Date());
		registration2.setMatricula("0001");
		
		Registration registrationSaved = repository.save(registration1);
		Assertions.assertThat(registrationSaved).isNotNull();
        Assertions.assertThat(registrationSaved.getId()).isNotNull();
        Assertions.assertThat(registrationSaved.getNome()).isEqualTo(registration1.getNome());
		
	}
	
	@Test
	@DisplayName("deletarRegistration - Sucesso")
	public void deleteRegistrationTest() {
		
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro(new Date());
		registration.setMatricula("001");
		
		Registration registrationSaved = repository.save(registration);
		repository.delete(registrationSaved);
		
		Optional<Registration> registrationOptional = repository.findById(registrationSaved.getId());
		
		Assertions.assertThat(registrationOptional).isEmpty();
		
	}
	
	@Test
	@DisplayName("buscaRegistrationByID - Sucesso")
	public void getByIdRegistrationTest() {
		
		Registration registration = new Registration();
		registration.setId(1L);
		registration.setNome("Deborah");
		registration.setDataDoRegistro(new Date());
		registration.setMatricula("001");
		
		Registration registrationSaved = repository.save(registration);
		
		Optional<Registration> registrationID = repository.findById(registrationSaved.getId());
		
		Assertions.assertThat(registrationID).isNotEmpty();
        Assertions.assertThat(registrationID).contains(registrationSaved);
		
	}

}
