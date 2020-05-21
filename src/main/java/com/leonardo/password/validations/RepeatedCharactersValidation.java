package com.leonardo.password.validations;

import static com.leonardo.password.utils.StringUtils.getErrorDescription;
import static com.leonardo.password.enums.ValidationEnum.REPEATED_CHARACTER;

import com.leonardo.password.validation.Validation;
import com.leonardo.password.vo.ValidationVO;

public class RepeatedCharactersValidation implements Validation{

	@Override
	public ValidationVO valid(String password) {
		boolean valid = true;
		for (int i = 0; i < password.length(); i++) {
			for (int j = 0; j < password.length(); j++) {				
				if(i != j && password.charAt(i) == password.charAt(j)) {
					valid = false;
					break;
				}
			}			
	    }
				
		return new ValidationVO(valid, getErrorDescription(valid, REPEATED_CHARACTER));
	}

}
