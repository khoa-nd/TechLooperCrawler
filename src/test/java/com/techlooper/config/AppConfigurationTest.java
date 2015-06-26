package com.techlooper.config;

import com.techlooper.crawler.Crawler;
import com.techlooper.crawler.linkedin.LinkedInSkillCrawler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigurationTest {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Crawler crawler() {
        return new LinkedInSkillCrawler();
    }
}
