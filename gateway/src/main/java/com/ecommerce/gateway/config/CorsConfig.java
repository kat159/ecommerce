package com.ecommerce.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 1. CORS
        corsConfiguration.addAllowedHeader("*");
        // corsConfiguration.addAllowedOrigin("*");  // **not work in spring version > 2.4.0, only allow one origin
        corsConfiguration.addAllowedOriginPattern("*");

        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);  // allow cookie

        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }
}
