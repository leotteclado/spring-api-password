package com.leonardo.password.validations;

import static com.leonardo.password.utils.StringUtils.getErrorDescription;
import static com.leonardo.password.enums.ValidationEnum.AT_LEAST_ONE_SPECIAL_CHARACTER;

import com.leonardo.password.validation.Validation;
import com.leonardo.password.vo.ValidationVO;

public class AtLeastOneSpecialCharacterValidation implements Validation{

	@Override
	public ValidationVO valid(String password) {
		boolean valid = false;
		for (int i = 0; i < password.length(); i++) {
			valid = String.valueOf(password.charAt(i)).matches("[}{,.^?~=+\\-_\\/*\\-+.\\|!@#$%¨&)(]");
			if(valid) {
				break;
			}
	    } 
				
		return new ValidationVO(valid, getErrorDescription(valid, AT_LEAST_ONE_SPECIAL_CHARACTER));
	}

}
