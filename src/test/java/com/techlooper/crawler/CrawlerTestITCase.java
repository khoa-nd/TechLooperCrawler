package com.techlooper.crawler;

import com.techlooper.config.AppConfigurationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
public class CrawlerTestITCase {

    @Resource
    private Crawler crawler;

    @Test
    public void testCrawl() throws Exception {
        crawler.crawl();
    }
}