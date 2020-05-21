package com.leonardo.password.controller;

import static com.leonardo.password.utils.StringUtils.asJsonString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.leonardo.password.service.PasswordService;
import com.leonardo.password.vo.ValidationInput;
import com.leonardo.password.vo.ValidationResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ValidationController.class)
public class ValidationControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private PasswordService passwordService;
	
	@Test
	public void testPassValidationSucess() throws Exception {
		ValidationInput input = new ValidationInput("Password1@");

		ValidationResult validationResult = new ValidationResult();
		validationResult.setValid(true);
		List<String> errors = new ArrayList<>();
		validationResult.setErrors(errors);		
		
		when(passwordService.passwordValidation(input)).thenReturn(validationResult);

        mockMvc.perform(
				post("/validation")			
				.content(asJsonString(input))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
}
