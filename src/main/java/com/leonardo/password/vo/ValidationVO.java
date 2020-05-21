package com.leonardo.password.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationVO {
	private boolean valid; 
	private String errorDescription;
	
}
