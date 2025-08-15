package com.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessageFactory {

	public enum ErrorType {
		GenericSystemError, PageNotFoundError, ServerError
	}

	private static Map<ErrorType, SystemErrorMessage> errorsMessages = new HashMap<>();

	static {
		errorsMessages.put(ErrorType.GenericSystemError, new SystemErrorMessage(
				"A generic error of type $errorCode occured, please refer ", "http://somedomain.com?errorCode="));
		errorsMessages.put(ErrorType.PageNotFoundError, new SystemErrorMessage(
				"Page not found error of type $errorCode occured, please refer ", "http://somedomain.com?errorCode="));
		errorsMessages.put(ErrorType.ServerError,
				new SystemErrorMessage("An internal server error of type $errorCode occured, please refer ",
						"http://somedomain.com?errorCode="));
	}

	public static ErrorMessage getError(ErrorType errorType) {
		return errorsMessages.get(errorType);
	}
}
