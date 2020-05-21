package com.leonardo.password.validations;

import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_SPECIAL_CHARACTER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.leonardo.password.validation.Validation;
import com.leonardo.password.vo.ValidationVO;

public class AtLeastOneSpecialCharacterValidationTest {
	
	Validation validation;
	
	@Before
	public void initValidation(){
		validation = new AtLeastOneSpecialCharacterValidation();
	}

	@Test
	public void testValid() {
		String password = "Abcdefgh1@";
		
		ValidationVO result = validation.valid(password);
		
		assertTrue(result.isValid());
		assertEquals("", result.getErrorDescription());
	}
	
	@Test
	public void testNotValid() {
		String password = "Abcdefgh1";
		
		ValidationVO result = validation.valid(password);
		
		assertFalse(result.isValid());
		assertEquals(AT_LEAST_ONE_SPECIAL_CHARACTER.getErrorDescription(), result.getErrorDescription());
	}

}
