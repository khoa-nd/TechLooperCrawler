package com.techlooper.crawler.linkedin;

import com.techlooper.crawler.CrawlerSource;
import com.techlooper.model.linkedin.LinkedInSkillResultList;
import com.techlooper.strategy.CrawlerStrategy;
import com.techlooper.strategy.impl.AlphabetCrawlerStrategy;
import com.techlooper.strategy.impl.DictionaryWordCrawlerStrategy;
import com.techlooper.strategy.impl.SeedSkillCrawlerStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by NguyenDangKhoa on 6/29/15.
 */
public class LinkedInJobTitleCrawlerSource implements CrawlerSource {

    @Override
    public String getEndpoint() {
        return "https://www.linkedin.com/ta/titleV2";
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
        strategies.add(new SeedSkillCrawlerStrategy());
        strategies.add(new DictionaryWordCrawlerStrategy());
        return strategies;
    }

    @Override
    public List<MultiValueMap<String, String>> getQueryParams(CrawlerStrategy crawlerStrategy) {
        List<MultiValueMap<String, String>> params = new ArrayList<>();
        Set<String> seedQueries = crawlerStrategy.getSeedQuery();
        for (String seedQuery : seedQueries) {
            MultiValueMap<String, String> queries = new LinkedMultiValueMap<>();
            queries.add("query", seedQuery);
            params.add(queries);
        }
        return params;
    }
}
