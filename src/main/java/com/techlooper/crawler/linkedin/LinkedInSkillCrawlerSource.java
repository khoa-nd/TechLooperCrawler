package com.techlooper.crawler.linkedin;

import com.techlooper.crawler.CrawlerSource;
import com.techlooper.model.linkedin.LinkedInSkillResultList;
import com.techlooper.strategy.CrawlerStrategy;
import com.techlooper.strategy.impl.AlphabetCrawlerStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
public class LinkedInSkillCrawlerSource implements CrawlerSource {

    @Override
    public String getEndpoint() {
        return "https://www.linkedin.com/ta/skill";
    }

    @Override
    public HttpEntity<?> getRequestEntity() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }

    @Override
    public Class<?> getResponseType() {
        return LinkedInSkillResultList.class;
    }

    @Override
    public List<CrawlerStrategy> getCrawlerStrategies() {
        List<CrawlerStrategy> strategies = new ArrayList<>();
        strategies.add(new AlphabetCrawlerStrategy());
        return strategies;
    }

    @Override
    public List<MultiValueMap<String, String>> getQueryParams(CrawlerStrategy crawlerStrategy) {
        List<MultiValueMap<String, String>> params = new ArrayList<>();
        List<String> seedQueries = crawlerStrategy.getSeedQuery();
        for (String seedQuery : seedQueries) {
            MultiValueMap<String, String> queries = new LinkedMultiValueMap<>();
            queries.add("query", seedQuery);
            params.add(queries);
        }
        return params;
    }
}
