package com.example.Library_Management.Exception;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntime(RuntimeException e){
		
		return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));
		
	}

}
