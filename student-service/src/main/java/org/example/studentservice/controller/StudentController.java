/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:35 PM
 */

package org.example.studentservice.controller;

import jakarta.validation.Valid;
import org.example.studentservice.client.SchoolClient;
import org.example.studentservice.model.request.StudentRequest;
import org.example.studentservice.model.response.Response;
import org.example.studentservice.model.response.SchoolResponse;
import org.example.studentservice.model.response.StudentResponse;
import org.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:2:35 PM
 */

@RestController
@RequestMapping("/student/")
public class StudentController {
    
    private StudentService studentService;
    private SchoolClient schoolClient;
    
    @Autowired
    public StudentController(StudentService service, SchoolClient schoolClient) {
        this.studentService = service;
        this.schoolClient = schoolClient;
    }
    
    @GetMapping
    public ResponseEntity<Response> getAll(){
        var result = this.studentService.getAll();
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
    
    @GetMapping("/with-school")
    public ResponseEntity<Response> getWithSchool(){
        var result = this.studentService.getAll();
        result.forEach(student -> {
            student.setSchoolResponse(schoolClient.findById(student.getSchoolId()));
        });
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
    
    @GetMapping("/school/{id}")
    public List<StudentResponse> getBySchoolId(@PathVariable("id") String id){
        var result = this.studentService.getBySchoolId(id);
        return result;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") String id){
        var result = this.studentService.getById(id).orElse(null);
        if(result != null){
            SchoolResponse schoolResponse = schoolClient.findById(result.getSchoolId());
            result.setSchoolResponse(schoolResponse);
        }
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
    
    @PostMapping
    public ResponseEntity<Response> create(
        @RequestBody @Valid StudentRequest request
    ){
        var result = this.studentService.save(request).orElse(null);
        if(result == null){
            return ResponseEntity.ok(
                new Response(500, "Failed", null)
            );
        }
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Response> update(
        @PathVariable("id") String id,
        @RequestBody @Valid StudentRequest request){
        var result = this.studentService.update(id,request).orElse(null);
        if(result == null){
            return ResponseEntity.ok(
                new Response(500, "Failed", null)
            );
        }
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") String id){
        var result = this.studentService.delete(id).orElse(null);
        if(result == null){
            return ResponseEntity.ok(
                new Response(500, "Failed", null)
            );
        }
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
}
