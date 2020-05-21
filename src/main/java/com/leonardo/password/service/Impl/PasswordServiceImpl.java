package com.leonardo.password.service.Impl;

import java.util.Arrays;
import java.util.List;

import com.leonardo.password.service.PasswordService;
import com.leonardo.password.validation.Validation;
import com.leonardo.password.validations.AtLeastOneLowercaseLetterValidation;
import com.leonardo.password.validations.AtLeastOneNumberValidation;
import com.leonardo.password.validations.AtLeastOneSpecialCharacterValidation;
import com.leonardo.password.validations.AtLeastOneUppercaseLetterValidation;
import com.leonardo.password.validations.MoreThanNineDigitValidation;
import com.leonardo.password.validations.RepeatedCharactersValidation;
import com.leonardo.password.validator.Validator;
import com.leonardo.password.vo.ValidationInput;
import com.leonardo.password.vo.ValidationResult;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasswordServiceImpl implements PasswordService{

	@Override
	public ValidationResult passwordValidation(ValidationInput input) {		
		List<Validation> validations = Arrays.asList(		
				new AtLeastOneLowercaseLetterValidation(),
				new AtLeastOneNumberValidation(),
				new AtLeastOneSpecialCharacterValidation(),
				new AtLeastOneUppercaseLetterValidation(),
				new RepeatedCharactersValidation(),
				new MoreThanNineDigitValidation());
				
		return new Validator().execute(validations, input.getPassword());		
	}

}
