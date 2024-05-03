package org.example.schoolservice.service;

import org.example.schoolservice.model.request.SchoolRequest;
import org.example.schoolservice.model.response.SchoolResponse;

import java.util.List;
import java.util.Optional;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:12 PM
 */
public interface SchoolService {
    List<SchoolResponse> getAll();
    Optional<SchoolResponse> getById(String id);
    Optional<SchoolResponse> save(SchoolRequest request);
    Optional<SchoolResponse> update(String id, SchoolRequest request);
    Optional<SchoolResponse> delete(String id);
}
