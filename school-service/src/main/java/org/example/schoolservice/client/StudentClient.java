package org.example.schoolservice.client;

import org.example.schoolservice.model.response.StudentResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:4:28 PM
 */
@HttpExchange
public interface StudentClient {
    @GetExchange("/student/school/{id}")
    public List<StudentResponse> findBySchool(@PathVariable("id") String schoolId);
}
