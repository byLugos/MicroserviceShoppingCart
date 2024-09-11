package com.cart.cart.infraestructure.config;

import com.cart.cart.domain.ports.api.CartIn;
import com.cart.cart.domain.ports.spi.CartOut;
import com.cart.cart.domain.service.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CartIn categoryIn(CartOut categoryOut){
        return new CartService(categoryOut);
    }
}
