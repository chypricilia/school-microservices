package org.example.schoolservice.repository;

import org.example.schoolservice.model.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:11 PM
 */

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {
}
