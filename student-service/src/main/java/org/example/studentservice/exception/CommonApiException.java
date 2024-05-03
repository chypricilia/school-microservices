/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:3:35 PM
 */

package org.example.studentservice.exception;

import org.springframework.http.HttpStatus;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:3:35 PM
 */
public class CommonApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
    private final Object errors;
    
    public CommonApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
        this.errors = null;
    }
    
    public CommonApiException(String message, HttpStatus status, Object errors) {
        super(message);
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    public Object getErrors() {
        return errors;
    }
}