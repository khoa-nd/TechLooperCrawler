package com.techlooper.crawler;

import com.techlooper.storage.CrawlerDataStorage;
import com.techlooper.strategy.CrawlerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
public abstract class Crawler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Crawler.class);

    @Resource
    private RestTemplate restTemplate;

    public void crawl() {
        CrawlerSource crawlerSource = getCrawlerSource();
        List<CrawlerStrategy> crawlerStrategies = crawlerSource.getCrawlerStrategies();

        for (CrawlerStrategy crawlerStrategy : crawlerStrategies) {
            for (MultiValueMap<String, String> params : crawlerSource.getQueryParams(crawlerStrategy)) {
                UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(crawlerSource.getEndpoint()).queryParams(params).build(true);
                URI requestURI = uriComponents.toUri();

                try {
                    ResponseEntity responseEntity = restTemplate.exchange(requestURI, HttpMethod.GET, crawlerSource.getRequestEntity(), crawlerSource.getResponseType());
                    HttpStatus status = responseEntity.getStatusCode();
                    if (status == HttpStatus.OK) {
                        List<?> data = getCrawlerDataProcessor().processRawData(responseEntity.getBody());
                        getCrawlerDataStorage().store(data);
                        LOGGER.info("{} {} {}", status.value(), requestURI, data.size());
                    } else {
                        LOGGER.info("{} {} {}", status.value(), requestURI, responseEntity.getBody());
                    }
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }
    }

    protected abstract CrawlerSource getCrawlerSource();

    protected abstract CrawlerDataProcessor getCrawlerDataProcessor();

    protected abstract CrawlerDataStorage getCrawlerDataStorage();

}
