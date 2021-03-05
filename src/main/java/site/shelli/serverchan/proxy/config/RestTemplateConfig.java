package site.shelli.serverchan.proxy.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author shen_xi
 * @create 2021/03/05 13:10
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(8L)).setReadTimeout(Duration.ofSeconds(8L)).build();
        return restTemplate;
    }
}
