package org.spring.template.webapp.exception;

import org.spring.template.core.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by osman on 9.5.2017.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends CustomException {

}
