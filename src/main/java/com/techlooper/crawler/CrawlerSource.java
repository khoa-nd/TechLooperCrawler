package com.techlooper.crawler;

import com.techlooper.strategy.CrawlerStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
public interface CrawlerSource {

    String getEndpoint();

    HttpEntity<?> getRequestEntity();

    Class<?> getResponseType();

    List<CrawlerStrategy> getCrawlerStrategies();

    List<MultiValueMap<String, String>> getQueryParams(CrawlerStrategy crawlerStrategy);

}
