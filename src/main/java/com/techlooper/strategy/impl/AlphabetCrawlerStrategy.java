package com.techlooper.strategy.impl;

import com.techlooper.strategy.CrawlerStrategy;
import com.techlooper.utils.LetterCombinationGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
public class AlphabetCrawlerStrategy implements CrawlerStrategy {

    @Override
    public List<String> getSeedQuery() {
        return LetterCombinationGenerator.generateLetterCombinations();
    }

}
