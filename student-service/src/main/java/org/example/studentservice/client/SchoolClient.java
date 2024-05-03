package org.example.studentservice.client;

import org.example.studentservice.model.response.SchoolResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:4:57 PM
 */
public interface SchoolClient {
    @GetExchange("/school/{id}")
    public SchoolResponse findById(@PathVariable("id") String schoolId);
}
