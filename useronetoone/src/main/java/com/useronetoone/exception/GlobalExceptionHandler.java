package com.useronetoone.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ IllegalStateException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {

		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.BAD_REQUEST + "");
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({UserNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleUserException(UserNotFoundException exception) {

		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.NOT_FOUND + "");
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ex.getBindingResult();

		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.BAD_REQUEST + "");
		error.setMessage(ex.getBindingResult().getAllErrors().get(0)
				.getDefaultMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
