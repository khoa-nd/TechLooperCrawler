package com.techlooper.strategy;

import java.util.Set;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
public interface CrawlerStrategy {

    Set<String> getSeedQuery();

}
