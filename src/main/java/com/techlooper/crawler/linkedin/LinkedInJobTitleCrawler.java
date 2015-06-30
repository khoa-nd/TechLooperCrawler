package com.techlooper.crawler.linkedin;

import com.techlooper.crawler.Crawler;
import com.techlooper.crawler.CrawlerDataProcessor;
import com.techlooper.crawler.CrawlerSource;
import com.techlooper.storage.CrawlerDataStorage;
import com.techlooper.storage.linkedin.LinkedInJobTitleCsvDataStorage;
import org.springframework.stereotype.Component;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
@Component
public class LinkedInJobTitleCrawler extends Crawler {

    @Override
    protected CrawlerSource getCrawlerSource() {
        return new LinkedInJobTitleCrawlerSource();
    }

    @Override
    protected CrawlerDataProcessor getCrawlerDataProcessor() {
        return new LinkedInJobTitleDataProcessor();
    }

    @Override
    protected CrawlerDataStorage getCrawlerDataStorage() {
        return new LinkedInJobTitleCsvDataStorage();
    }
}
