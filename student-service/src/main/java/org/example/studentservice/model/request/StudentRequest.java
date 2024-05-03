/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:28 PM
 */

package org.example.studentservice.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:28 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(min = 36, max = 36)
    private String schoolId;
    @NotNull
    @Size(max = 36)
    private String grade;
    @NotNull
    @Size(max = 10)
    private String gender;
}
