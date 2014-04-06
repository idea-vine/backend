package com.bigidea.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;



import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class RestServiceController {
	private Log logger = LogFactory.getLog(getClass());
	
	private ObjectMapper jacksonObjectMapper = new ObjectMapper();
	
	@ExceptionHandler(Exception.class)
	public void handleException(Exception ex, HttpServletResponse response) {
		logger.error(" EXception :: "+ex.getLocalizedMessage());
		ServiceResponse<String, Exception> serviceResponse = new ServiceResponse<String, Exception>(ex.getLocalizedMessage(), ex, true);
		/*
		 * ResponseBody doesn't work with ExceptionHandler, so we're writing the
		 * response directly using a Jackson ObjectMapper.
		 * 
		 */
		try {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.getWriter().append(jacksonObjectMapper.writeValueAsString(serviceResponse)).close();
		} catch (IOException ioe) {
			logger.error("Could not serialize ServiceResponse: " + ioe.getMessage());
		}
	}

}
