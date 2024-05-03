package org.example.schoolservice.service;

import lombok.extern.slf4j.Slf4j;
import org.example.schoolservice.model.entity.SchoolEntity;
import org.example.schoolservice.model.request.SchoolRequest;
import org.example.schoolservice.model.response.SchoolResponse;
import org.example.schoolservice.repository.SchoolRepository;
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
 * Time:1:15 PM
 */
@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {
    private SchoolRepository schoolRepository;
    
    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
 
    @Override
    public List<SchoolResponse> getAll() {
        var result = this.schoolRepository.findAll();
        log.info("Get school is empty, data: {}", result);
        if(result.isEmpty()){
            return Collections.emptyList();
        }
        
        return result.stream()
                   .map(this::setResponse)
                   .collect(Collectors.toList());
    }
    
    private SchoolResponse setResponse(SchoolEntity entity){
        SchoolResponse result = new SchoolResponse();
        BeanUtils.copyProperties(entity, result);
        return result;
    }
    
    @Override
    public Optional<SchoolResponse> getById(String id) {
        var result = this.schoolRepository.findById(id).orElse(null);
        log.info("Get school by id, data: {}", result);
        if(result == null) {
            return Optional.empty();
        }
        return Optional.of(this.setResponse(result));
    }
    
    @Override
    public Optional<SchoolResponse> save(SchoolRequest request) {
        SchoolEntity entity = new SchoolEntity();
        return saveSchool(request, entity);
    }
    
    @Override
    public Optional<SchoolResponse> update(String id, SchoolRequest request) {
        SchoolEntity entity = schoolRepository.findById(id).orElse(null);
        if(entity == null){
            log.error("Get school by id: {} not found", id);
            return Optional.empty();
        }
        
        return saveSchool(request, entity);
    }
    
    private Optional<SchoolResponse> saveSchool(SchoolRequest request, SchoolEntity entity) {
        BeanUtils.copyProperties(request, entity);
        entity.setId(UUID.randomUUID().toString());
        try{
            this.schoolRepository.save(entity);
            SchoolResponse result = this.setResponse(entity);
            log.info("Save school success, data: {}", result);
            return Optional.of(result);
        } catch (Exception e){
            log.error("Save school failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
    
    @Override
    public Optional<SchoolResponse> delete(String id) {
        SchoolEntity entity = schoolRepository.findById(id).orElse(null);
        if(entity == null){
            log.error("Get school by id: {} not found", id);
            return Optional.empty();
        }
        
        try{
            this.schoolRepository.delete(entity);
            SchoolResponse result = this.setResponse(entity);
            log.info("Delete school success, data: {}", result);
            return Optional.of(result);
        } catch (Exception e){
            log.error("Delete school failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
    
}
