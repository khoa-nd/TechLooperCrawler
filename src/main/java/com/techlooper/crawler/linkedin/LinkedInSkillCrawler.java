package com.techlooper.crawler.linkedin;

import com.techlooper.crawler.Crawler;
import com.techlooper.crawler.CrawlerDataProcessor;
import com.techlooper.crawler.CrawlerSource;
import com.techlooper.model.linkedin.LinkedInSkill;
import com.techlooper.storage.CrawlerDataStorage;
import com.techlooper.storage.linkedin.LinkedInSkillCsvDataStorage;
import org.springframework.stereotype.Component;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
@Component
public class LinkedInSkillCrawler extends Crawler {

    @Override
    protected CrawlerSource getCrawlerSource() {
        return new LinkedInSkillCrawlerSource();
    }

    @Override
    protected CrawlerDataProcessor getCrawlerDataProcessor() {
        return new LinkedInSkillDataProcessor();
    }

    @Override
    protected CrawlerDataStorage getCrawlerDataStorage() {
        return new LinkedInSkillCsvDataStorage();
    }
}
