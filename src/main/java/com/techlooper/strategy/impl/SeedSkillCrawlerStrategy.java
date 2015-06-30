package com.techlooper.strategy.impl;

import com.techlooper.strategy.CrawlerStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by NguyenDangKhoa on 6/29/15.
 */
public class SeedSkillCrawlerStrategy implements CrawlerStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeedSkillCrawlerStrategy.class);

    @Override
    public Set<String> getSeedQuery() {
        Set<String> seedQuery = new HashSet<>();
        File file = new File("linkedin-skill.csv");
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), Charset.forName("UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (StringUtils.isNotEmpty(line)) {
                    String[] tokens = StringUtils.split(line, ',');
                    if (tokens != null && tokens.length == 2) {
                        String[] skillTokens = StringUtils.splitPreserveAllTokens(tokens[1]);
                        seedQuery.addAll(Arrays.asList(skillTokens));
                    }
                }
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return seedQuery;
    }

}
