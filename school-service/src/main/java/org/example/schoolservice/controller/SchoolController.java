/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:36 PM
 */

package org.example.schoolservice.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import org.example.schoolservice.client.StudentClient;
import org.example.schoolservice.model.request.SchoolRequest;
import org.example.schoolservice.model.response.Response;
import org.example.schoolservice.model.response.SchoolResponse;
import org.example.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:1:36 PM
 */


@RestController
@RequestMapping("/school")
public class SchoolController {
    
    private SchoolService schoolService;
    
    private StudentClient studentClients;
    
    @Autowired
    public SchoolController(SchoolService service, StudentClient studentClient) {
        this.schoolService = service;
        this.studentClients = studentClient;
    }
    
    @GetMapping
    public ResponseEntity<Response> getAll(){
        var result = this.schoolService.getAll();
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
    
    @GetMapping("/{id}")
    public SchoolResponse getById(@PathVariable("id") String id){
        var result = this.schoolService.getById(id).orElse(null);
        return result;
    }
    
    @GetMapping("/with-student")
    public ResponseEntity<Response> getWithStudent(){
        var result = this.schoolService.getAll();
        result.forEach(school -> {
            school.setStudents(studentClients.findBySchool(school.getId()));
        });
        return ResponseEntity.ok(
            new Response(200, "Success", result)
        );
    }
    
    @PostMapping
    public ResponseEntity<Response> create(
        @RequestBody @Valid SchoolRequest request
    ){
        var result = this.schoolService.save(request).orElse(null);
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
        @RequestBody @Valid SchoolRequest request){
        var result = this.schoolService.update(id,request).orElse(null);
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
        var result = this.schoolService.delete(id).orElse(null);
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
