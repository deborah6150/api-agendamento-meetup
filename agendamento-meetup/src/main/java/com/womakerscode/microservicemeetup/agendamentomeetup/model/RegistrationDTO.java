package com.womakerscode.microservicemeetup.agendamentomeetup.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

	private Long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private LocalDate dataDoRegistro;
	
	@NotEmpty
	private String registration;
}
