/**
 * 
 */
package com.rajiv.dashboard.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author rajk0517
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

  /**
   * Instantiates a new Resource not found exception.
   *
   * @param message the message
   */
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
