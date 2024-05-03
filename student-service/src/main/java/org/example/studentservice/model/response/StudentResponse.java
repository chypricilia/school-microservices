/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:30 PM
 */

package org.example.studentservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:30 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String id;
    private String name;
    private String schoolId;
    private int age;
    private String gender;
}
