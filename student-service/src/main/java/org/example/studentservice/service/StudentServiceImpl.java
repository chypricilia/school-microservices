/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:48 PM
 */

package org.example.studentservice.service;

import lombok.extern.slf4j.Slf4j;
import org.example.studentservice.model.entity.StudentEntity;
import org.example.studentservice.model.request.StudentRequest;
import org.example.studentservice.model.response.StudentResponse;
import org.example.studentservice.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:48 PM
 */

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    
    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.studentRepository = repository;
    }
    
    @Override
    public List<StudentResponse> getAll() {
        var result = this.studentRepository.findAll();
        log.info("Get Student is empty, data: {}", result);
        if(result.isEmpty()){
            return Collections.emptyList();
        }
        
        return result.stream()
                   .map(this::setResponse)
                   .collect(Collectors.toList());
    }
    
    private StudentResponse setResponse(StudentEntity entity){
        StudentResponse result = new StudentResponse();
        BeanUtils.copyProperties(entity, result);
        return result;
    }
    
    @Override
    public Optional<StudentResponse> getById(String id) {
        var result = this.studentRepository.findById(id).orElse(null);
        log.info("Get Student by id, data: {}", result);
        if(result == null) {
            return Optional.empty();
        }
        return Optional.of(this.setResponse(result));
    }
    
    @Override
    public List<StudentResponse> getBySchoolId(String id) {
        var result = this.studentRepository.findBySchoolId(id);
        log.info("Get Student by school id:{} is empty, data: {}", id, result);
        if(result.isEmpty()){
            return Collections.emptyList();
        }
        
        return result.stream()
                   .map(this::setResponse)
                   .collect(Collectors.toList());
    }
    
    @Override
    public Optional<StudentResponse> save(StudentRequest request) {
        StudentEntity entity = new StudentEntity();
        entity.setId(UUID.randomUUID().toString());
        return saveStudent(request, entity);
    }
    
    @Override
    public Optional<StudentResponse> update(String id, StudentRequest request) {
        StudentEntity entity = studentRepository.findById(id).orElse(null);
        if(entity == null){
            log.error("Get Student by id: {} not found", id);
            return Optional.empty();
        }
        
        return saveStudent(request, entity);
    }
    
    private Optional<StudentResponse> saveStudent(StudentRequest request, StudentEntity entity) {
        BeanUtils.copyProperties(request, entity);
        try{
            this.studentRepository.save(entity);
            StudentResponse result = this.setResponse(entity);
            log.info("Save Student success, data: {}", result);
            return Optional.of(result);
        } catch (Exception e){
            log.error("Save Student failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
    
    @Override
    public Optional<StudentResponse> delete(String id) {
        StudentEntity entity = studentRepository.findById(id).orElse(null);
        if(entity == null){
            log.error("Get Student by id: {} not found", id);
            return Optional.empty();
        }
        
        try{
            this.studentRepository.delete(entity);
            StudentResponse result = this.setResponse(entity);
            log.info("Delete Student success, data: {}", result);
            return Optional.of(result);
        } catch (Exception e){
            log.error("Delete Student failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
