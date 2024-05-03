/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:02 PM
 */

package org.example.schoolservice.model.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:02 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {
    private int statusCode;
    private Object message;
    private Object data;
}
