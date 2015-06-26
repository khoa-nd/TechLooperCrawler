package com.techlooper.crawler;

import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/25/15.
 */
public interface CrawlerDataProcessor<T> {

    List<T> processRawData(Object responseBody);

}
