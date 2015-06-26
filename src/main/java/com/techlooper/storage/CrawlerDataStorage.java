package com.techlooper.storage;

import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/25/15.
 */
public interface CrawlerDataStorage<T> {

    void store(List<T> dataset);

}
