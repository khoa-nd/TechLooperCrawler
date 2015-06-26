package com.techlooper.storage.impl;

import com.techlooper.model.linkedin.LinkedInSkill;
import com.techlooper.storage.linkedin.LinkedInSkillCsvDataStorage;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CsvDataStorageTest {

    @Test
    public void testStore() throws Exception {
        final List<LinkedInSkill> skills = Arrays.asList(new LinkedInSkill("1", "Java"), new LinkedInSkill("2", "PHP"));

        CsvDataStorage<LinkedInSkill> csvDataStorage = new LinkedInSkillCsvDataStorage();
        csvDataStorage.store(skills);
    }
}