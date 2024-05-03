/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:40 PM
 */

package org.example.schoolservice.exception;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:48 PM
 */
public class JsonParseException extends RuntimeException {
    public JsonParseException(String message, Throwable cause) {
        super(message, cause);
    }
}