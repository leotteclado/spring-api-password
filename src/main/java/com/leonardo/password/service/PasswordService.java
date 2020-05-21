package com.leonardo.password.service;

import com.leonardo.password.vo.ValidationInput;
import com.leonardo.password.vo.ValidationResult;

public interface PasswordService {
	ValidationResult passwordValidation(ValidationInput input);
}
