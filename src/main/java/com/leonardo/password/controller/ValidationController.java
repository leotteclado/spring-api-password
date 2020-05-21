package com.leonardo.password.controller;

import com.leonardo.password.service.PasswordService;
import com.leonardo.password.vo.ValidationInput;
import com.leonardo.password.vo.ValidationResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("validation")
public class ValidationController {
	
	@Autowired
	PasswordService passwordService;
	
    @PostMapping
    @ApiOperation(value = "Password validation")
    @ResponseStatus(HttpStatus.CREATED)
    public ValidationResult passValidation(@RequestBody ValidationInput input) {
        return passwordService.passwordValidation(input);
    }

}
