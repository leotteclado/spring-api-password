package com.leonardo.password.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ValidationEnum {

	AT_LEAST_ONE_LOWERCASE_LETTER("at least one lowercase letter"),
	AT_LEAST_ONE_NUMBER("at least one number"),
	AT_LEAST_ONE_SPECIAL_CHARACTER("at least one special character"),
	AT_LEAST_ONE_UPPERCASE_LETTER("at least one uppercase letter"),
	REPEATED_CHARACTER("repeated character"),
	LESS_THAN_NINE_DIGIT("less than 9 digit");
	
	private @Getter @Setter String errorDescription;
}
