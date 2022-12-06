package com.shop.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalErrorHandler {
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> ProductException(ProductException e,WebRequest req){
		ErrorDetails err = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setDatetime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<ErrorDetails> AddressException(AddressException e,WebRequest req){
		ErrorDetails err = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setDatetime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> CustomerException(CustomerException e,WebRequest req){
		ErrorDetails err = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setDatetime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> normalException(Exception e,WebRequest req){
		ErrorDetails err = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setDatetime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandleException(NoHandlerFoundException e,WebRequest req){
		ErrorDetails err = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setDatetime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgsInvalid(MethodArgumentNotValidException e,WebRequest wr) {
		ErrorDetails err = new ErrorDetails();
		err.setDatetime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(e.getBindingResult().getFieldError().getDefaultMessage());
	
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}

}
