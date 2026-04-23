package userservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
public class UserConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    };
}
