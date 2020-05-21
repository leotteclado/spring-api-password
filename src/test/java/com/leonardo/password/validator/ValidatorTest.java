package com.leonardo.password.validator;

import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_NUMBER;
import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_SPECIAL_CHARACTER;
import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_UPPERCASE_LETTER;
import static com.leonardo.password.enums.ValidationEnum.LESS_THAN_NINE_DIGIT;
import static com.leonardo.password.enums.ValidationEnum.REPEATED_CHARACTER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.leonardo.password.validation.Validation;
import com.leonardo.password.validations.AtLeastOneLowercaseLetterValidation;
import com.leonardo.password.validations.AtLeastOneNumberValidation;
import com.leonardo.password.validations.AtLeastOneSpecialCharacterValidation;
import com.leonardo.password.validations.AtLeastOneUppercaseLetterValidation;
import com.leonardo.password.validations.MoreThanNineDigitValidation;
import com.leonardo.password.validations.RepeatedCharactersValidation;
import com.leonardo.password.vo.ValidationResult;

public class ValidatorTest {
	
	List<Validation> validations;
	
	@Before
	public void initValidation(){
		validations = Arrays.asList(		
				new AtLeastOneLowercaseLetterValidation(),
				new AtLeastOneNumberValidation(),
				new AtLeastOneSpecialCharacterValidation(),
				new AtLeastOneUppercaseLetterValidation(),
				new RepeatedCharactersValidation(),
				new MoreThanNineDigitValidation());
	}

	@Test
	public void testValid() {
		String password = "Abcdefg1@";
		
		ValidationResult passwordValidation = new Validator().execute(validations, password);
		
		assertTrue(passwordValidation.isValid());
		assertTrue(passwordValidation.getErrors().isEmpty());
	}
	
	@Test
	public void testErrors() {		
		String password = "aa";
	
		ValidationResult passwordValidation = new Validator().execute(validations, password);
		
		assertFalse(passwordValidation.isValid());
		assertTrue(passwordValidation.getErrors().contains(AT_LEAST_ONE_NUMBER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(AT_LEAST_ONE_SPECIAL_CHARACTER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(AT_LEAST_ONE_UPPERCASE_LETTER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(REPEATED_CHARACTER.getErrorDescription()));
		assertTrue(passwordValidation.getErrors().contains(LESS_THAN_NINE_DIGIT.getErrorDescription()));
		
	}

}
