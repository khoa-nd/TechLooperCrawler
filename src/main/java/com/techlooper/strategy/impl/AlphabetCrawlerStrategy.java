package com.techlooper.strategy.impl;

import com.techlooper.strategy.CrawlerStrategy;
import com.techlooper.utils.LetterCombinationGenerator;

import java.util.Set;

/**
 * Created by NguyenDangKhoa on 6/24/15.
 */
public class AlphabetCrawlerStrategy implements CrawlerStrategy {

    @Override
    public Set<String> getSeedQuery() {
        return LetterCombinationGenerator.generateLetterCombinations();
    }

}
