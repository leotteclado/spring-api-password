package com.leonardo.password.validator;

import java.util.ArrayList;
import java.util.List;

import com.leonardo.password.validation.Validation;
import com.leonardo.password.vo.ValidationResult;
import com.leonardo.password.vo.ValidationVO;

public class Validator {
	
	public ValidationResult execute(List<Validation> validations, String password) {
		ValidationResult validationResult = new ValidationResult();
		List<String> errorsDescription = new ArrayList<>();
		
		validations.stream().forEach(validation -> {
			ValidationVO extract = extractValidation(validation,password);
			if(!extract.isValid()) {
				errorsDescription.add(extract.getErrorDescription());
			}
		});		
		validationResult.setErrors(errorsDescription);
		
		if(errorsDescription.isEmpty()) {
			validationResult.setValid(true);			
		}else {
			validationResult.setValid(false);
		}
		
		return validationResult;
	}
	
	private ValidationVO extractValidation(Validation validation, String password) {
		return validation.valid(password);		
	}
}
