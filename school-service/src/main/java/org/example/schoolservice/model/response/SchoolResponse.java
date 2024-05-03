/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:01 PM
 */

package org.example.schoolservice.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:01 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolResponse {
    private String id;
    private String code;
    private String name;
    private List<StudentResponse> students;
}
