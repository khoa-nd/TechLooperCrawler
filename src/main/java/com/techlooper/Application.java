package com.techlooper;

import com.techlooper.config.AppConfiguration;
import com.techlooper.crawler.Crawler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by NguyenDangKhoa on 6/27/15.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Crawler crawler = applicationContext.getBean("crawler", Crawler.class);
        crawler.crawl();
    }

}
