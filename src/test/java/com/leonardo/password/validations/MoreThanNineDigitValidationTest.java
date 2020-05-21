package com.leonardo.password.validations;

import static com.leonardo.password.enums.ValidationEnum.LESS_THAN_NINE_DIGIT;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.leonardo.password.validation.Validation;
import com.leonardo.password.vo.ValidationVO;

public class MoreThanNineDigitValidationTest {
	
	Validation validation;
	
	@Before
	public void initValidation(){
		validation = new MoreThanNineDigitValidation();
	}

	@Test
	public void testValid() {
		String password = "Adbdefg1#";
		
		ValidationVO result = validation.valid(password);
		
		assertTrue(result.isValid());
		assertEquals("", result.getErrorDescription());
	}
	
	@Test
	public void testNotValid() {
		String password = "Adefg1#";
		
		ValidationVO result = validation.valid(password);
		
		assertFalse(result.isValid());
		assertEquals(LESS_THAN_NINE_DIGIT.getErrorDescription(), result.getErrorDescription());
	}

}
