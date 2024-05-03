/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:11:53 AM
 */

package org.example.schoolservice.model.entity;

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
 * Time:11:53 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_school")
public class SchoolEntity {
    @Id
    @Column(name = "id", length = 36, nullable = false, unique = true)
    private String id;
    
    @Column(name = "school_code", length = 10, nullable = false, unique = true)
    private String code;
    
    @Column(name = "school_name", nullable = false)
    private String name;
    
    
}
