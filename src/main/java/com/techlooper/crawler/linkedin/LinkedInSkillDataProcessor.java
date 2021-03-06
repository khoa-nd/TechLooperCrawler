package com.techlooper.crawler.linkedin;

import com.techlooper.crawler.CrawlerDataProcessor;
import com.techlooper.model.linkedin.LinkedInSkill;
import com.techlooper.model.linkedin.LinkedInSkillResultList;

import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/25/15.
 */
public class LinkedInSkillDataProcessor implements CrawlerDataProcessor<LinkedInSkill> {

    @Override
    public List<LinkedInSkill> processRawData(Object responseBody) {
        LinkedInSkillResultList resultList = (LinkedInSkillResultList) responseBody;
        return resultList.getResultList();
    }

}
