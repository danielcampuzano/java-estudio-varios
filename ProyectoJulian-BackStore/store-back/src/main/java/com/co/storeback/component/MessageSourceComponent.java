package com.co.storeback.component;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceComponent {

	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String code) {
		return messageSource.getMessage(code, null, new Locale(""));
	}
	
	public String getMessage(String code, Object[] params) {
		return messageSource.getMessage(code, params, new Locale(""));
	}
	
}
