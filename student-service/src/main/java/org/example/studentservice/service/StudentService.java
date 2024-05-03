package org.example.studentservice.service;

import org.example.studentservice.model.request.StudentRequest;
import org.example.studentservice.model.response.StudentResponse;

import java.util.List;
import java.util.Optional;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:43 PM
 */
public interface StudentService {
    List<StudentResponse> getAll();
    Optional<StudentResponse> getById(String id);
    List<StudentResponse> getBySchoolId(String id);
    Optional<StudentResponse> save(StudentRequest request);
    Optional<StudentResponse> update(String id, StudentRequest request);
    Optional<StudentResponse> delete(String id);
}
