package com.leonardo.password.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonardo.password.enums.ValidationEnum;

public class StringUtils {
	public static final String NO_ERROR_DESCRIPTION = "";

	public static String getErrorDescription(boolean valid, ValidationEnum description) {
		return valid ? NO_ERROR_DESCRIPTION : description.getErrorDescription();
	}

	public static String asJsonString(final Object obj)  {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (IOException e) {
            return "";
        }
    }
}
