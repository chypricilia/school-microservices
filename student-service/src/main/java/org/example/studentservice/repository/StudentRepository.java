package org.example.studentservice.repository;

import org.example.studentservice.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:32 PM
 */

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
}
