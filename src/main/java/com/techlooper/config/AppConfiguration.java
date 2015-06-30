package com.techlooper.config;

import com.techlooper.crawler.Crawler;
import com.techlooper.crawler.linkedin.LinkedInJobTitleCrawler;
import com.techlooper.crawler.linkedin.LinkedInSkillCrawler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by NguyenDangKhoa on 6/23/15.
 */
@Configuration
@ComponentScan(basePackages = "com.techlooper")
public class AppConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Crawler crawler() {
        return new LinkedInJobTitleCrawler();
    }

}
