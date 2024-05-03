/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:4:51 PM
 */

package org.example.schoolservice.config;

import org.example.schoolservice.client.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;

/**
 * Author: Pricilia Anna V
 * Date:5/3/2024
 * Time:4:51 PM
 */
@Configuration
public class WebClientConfig {
    private LoadBalancedExchangeFilterFunction filterFunction;
    
    @Autowired
    public WebClientConfig(LoadBalancedExchangeFilterFunction filterFunction) {
        this.filterFunction = filterFunction;
    }
    
    @Bean
    public WebClient studentWebClient() {
        return WebClient.builder()
                   .baseUrl("http://student-service")
                   .filter(filterFunction)
                   .build();
    }
    
    @Bean
    public StudentClient studentClient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                                                              .builder(WebClientAdapter.forClient(studentWebClient()))
                                                              .build();
        return httpServiceProxyFactory.createClient(StudentClient.class);
    }
}
