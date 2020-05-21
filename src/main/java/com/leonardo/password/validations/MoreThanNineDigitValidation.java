package com.leonardo.password.validations;

import static com.leonardo.password.utils.StringUtils.getErrorDescription;
import static com.leonardo.password.enums.ValidationEnum.LESS_THAN_NINE_DIGIT;

import com.leonardo.password.validation.Validation;
import com.leonardo.password.vo.ValidationVO;

public class MoreThanNineDigitValidation implements Validation{
	
	private static final Integer DIGIT_COUNT = 9;

	@Override
	public ValidationVO valid(String password) {		
		boolean valid = password.length() >= DIGIT_COUNT;		
				
		return new ValidationVO(valid, getErrorDescription(valid, LESS_THAN_NINE_DIGIT));
	}

}
