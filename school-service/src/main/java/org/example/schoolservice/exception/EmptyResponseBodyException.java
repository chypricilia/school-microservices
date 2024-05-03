/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:40 PM
 */

package org.example.schoolservice.exception;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:45 PM
 */
public class EmptyResponseBodyException extends RuntimeException {
    public EmptyResponseBodyException(String message) {
        super(message);
    }
    
    public EmptyResponseBodyException(String message, Throwable cause) {
        super(message, cause);
    }
}