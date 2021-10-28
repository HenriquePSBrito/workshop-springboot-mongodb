package com.javamongodb.workshop.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javamongodb.workshop.services.exception.ObjectNotFoundException;

@ControllerAdvice //classe vai tratar erros nas requisicoes
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) //identificar a exceção e executar todo o metodo abaixo
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
	
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
