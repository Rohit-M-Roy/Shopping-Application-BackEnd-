package com.shop.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {
	
	private LocalDateTime datetime;
	private String message;
	private String description;
	
	@Override
	public String toString() {
		return "MyErrorDetails [ldt=" + datetime + ", Message=" + message + ", Description=" + description + "]";
	}

}
