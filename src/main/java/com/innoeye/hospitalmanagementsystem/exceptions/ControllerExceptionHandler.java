package com.innoeye.hospitalmanagementsystem.exceptions;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.OK.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.OK);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorMessage> badRequestException(BadRequestException ex, WebRequest request) {
		
		ErrorMessage message = new ErrorMessage(HttpStatus.OK.value(), new Date(), ex.getMessage(),request.getDescription(false));

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.OK);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<List> processUnmergeException(final MethodArgumentNotValidException ex) {

		List list = ex.getBindingResult().getAllErrors().stream()
				.map(fieldError -> fieldError.getDefaultMessage()+" - ColorExceptionHandler")
				.collect(Collectors.toList());

		return new ResponseEntity<List>(list, HttpStatus.BAD_REQUEST);
	}
}
