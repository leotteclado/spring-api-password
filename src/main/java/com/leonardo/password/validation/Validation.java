package com.leonardo.password.validation;

import com.leonardo.password.vo.ValidationVO;

public interface Validation {
	ValidationVO valid(String password);
}
