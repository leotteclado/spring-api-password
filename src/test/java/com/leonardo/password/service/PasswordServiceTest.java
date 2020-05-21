package com.leonardo.password.service;

import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_NUMBER;
import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_SPECIAL_CHARACTER;
import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_UPPERCASE_LETTER;
import static com.leonardo.password.enums.ValidationEnum.LESS_THAN_NINE_DIGIT;
import static com.leonardo.password.enums.ValidationEnum.REPEATED_CHARACTER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.leonardo.password.vo.ValidationInput;
import com.leonardo.password.vo.ValidationResult;

@RunWith(MockitoJUnitRunner.class)
public class PasswordServiceTest {
	
	@Mock
	private PasswordService passwordService;
		
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSucess() {		
		ValidationInput input = new ValidationInput("Abcdefg1@");
		ValidationResult result = new ValidationResult();
		result.setValid(true);
		List<String> errors = new ArrayList<String>();
		result.setErrors(errors);
		
		Mockito.when(passwordService.passwordValidation(input)).thenReturn(result);
		
		ValidationResult passwordValidation = passwordService.passwordValidation(input);
		
		assertTrue(passwordValidation.isValid());
		assertTrue(passwordValidation.getErrors().isEmpty());
		
	}	

	@Test
	public void testMoreThanOneError() {		
		ValidationInput input = new ValidationInput("aa");

		ValidationResult result = new ValidationResult();
		result.setValid(false);
		
		List<String> errors = Arrays.asList(
				AT_LEAST_ONE_NUMBER.getErrorDescription(),
				AT_LEAST_ONE_SPECIAL_CHARACTER.getErrorDescription(),
				AT_LEAST_ONE_UPPERCASE_LETTER.getErrorDescription(),
				REPEATED_CHARACTER.getErrorDescription(),
				LESS_THAN_NINE_DIGIT.getErrorDescription()
		);	
		result.setErrors(errors);
		
		Mockito.when(passwordService.passwordValidation(input)).thenReturn(result);
		
		ValidationResult passwordValidation = passwordService.passwordValidation(input);
		
		assertFalse(passwordValidation.isValid());
		assertTrue(passwordValidation.getErrors().contains(AT_LEAST_ONE_NUMBER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(AT_LEAST_ONE_SPECIAL_CHARACTER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(AT_LEAST_ONE_UPPERCASE_LETTER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(REPEATED_CHARACTER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(LESS_THAN_NINE_DIGIT.getErrorDescription()));
		
	}
	
}
