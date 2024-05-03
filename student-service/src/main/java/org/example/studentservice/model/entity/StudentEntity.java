/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:25 PM
 */

package org.example.studentservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:25 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_student")
public class StudentEntity {
    @Id
    @Column(name = "id", length = 36, nullable = false, unique = true)
    private String id;
    @Column(name = "student_name", length = 100, nullable = false)
    private String name;
    @Column(name = "school_id", length = 36, nullable = false)
    private String schoolId;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "gender", length = 10)
    private String gender;
}
