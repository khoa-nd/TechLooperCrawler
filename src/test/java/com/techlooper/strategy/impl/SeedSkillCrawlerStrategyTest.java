package com.techlooper.strategy.impl;

import org.junit.Test;

import java.util.Set;

public class SeedSkillCrawlerStrategyTest {

    @Test
    public void testGetSeedQuery() throws Exception {
        SeedSkillCrawlerStrategy strategy = new SeedSkillCrawlerStrategy();
        Set<String> seedQuery = strategy.getSeedQuery();
        seedQuery.size();
    }
}