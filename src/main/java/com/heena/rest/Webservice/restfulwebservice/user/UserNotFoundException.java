/**
 * 
 */
package com.heena.rest.Webservice.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author HEENA VERMA
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {


	public UserNotFoundException(String message) {
		super(message);
	}

}
