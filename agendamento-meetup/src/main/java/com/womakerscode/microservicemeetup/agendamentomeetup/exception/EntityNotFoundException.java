package com.womakerscode.microservicemeetup.agendamentomeetup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
	
	public EntityNotFoundException(String mensagem) {
		super(mensagem);
	}

	
}
