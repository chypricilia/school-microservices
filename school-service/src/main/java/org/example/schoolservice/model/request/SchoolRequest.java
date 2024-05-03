/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:00 PM
 */

package org.example.schoolservice.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:00 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolRequest {
    @NotNull
    @Size(max = 10)
    private String code;
    
    @NotNull
    private String name;
}
