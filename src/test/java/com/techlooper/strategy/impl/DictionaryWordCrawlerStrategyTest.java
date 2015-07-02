package com.techlooper.strategy.impl;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class DictionaryWordCrawlerStrategyTest {

    @Test
    public void testGetSeedQuery() throws Exception {
        DictionaryWordCrawlerStrategy strategy = new DictionaryWordCrawlerStrategy();
        Set<String> seedQuery = strategy.getSeedQuery();
        assertTrue(seedQuery.size() == 109583);
    }
}