/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:3:38 PM
 */

package org.example.studentservice.exception;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:3:38 PM
 */
public class EmptyResponseBodyException extends RuntimeException {
    public EmptyResponseBodyException(String message) {
        super(message);
    }
    
    public EmptyResponseBodyException(String message, Throwable cause) {
        super(message, cause);
    }
}