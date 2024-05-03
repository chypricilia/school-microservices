/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:4:59 PM
 */

package org.example.studentservice.config;

import org.example.studentservice.client.SchoolClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:4:59 PM
 */
@Configuration
public class WebClientConfig {
    private LoadBalancedExchangeFilterFunction filterFunction;
    
    @Autowired
    public WebClientConfig(LoadBalancedExchangeFilterFunction filterFunction) {
        this.filterFunction = filterFunction;
    }
    
    @Bean
    public WebClient schoolWebClient() {
        return WebClient.builder()
                   .baseUrl("http://school-service")
                   .filter(filterFunction)
                   .build();
    }
    
    @Bean
    public SchoolClient schoolClient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                                                              .builder(WebClientAdapter.forClient(schoolWebClient()))
                                                              .build();
        return httpServiceProxyFactory.createClient(SchoolClient.class);
    }
}