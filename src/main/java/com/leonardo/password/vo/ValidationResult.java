package com.leonardo.password.vo;

import java.util.List;

import lombok.Data;

@Data 
public class ValidationResult {
	private boolean valid; 
	private List<String> errors;
}
