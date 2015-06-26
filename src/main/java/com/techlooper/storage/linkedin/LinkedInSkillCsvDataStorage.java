package com.techlooper.storage.linkedin;

import com.techlooper.model.linkedin.LinkedInSkill;
import com.techlooper.storage.impl.CsvDataStorage;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Created by NguyenDangKhoa on 6/25/15.
 */
public class LinkedInSkillCsvDataStorage extends CsvDataStorage<LinkedInSkill> {

    @Override
    public String getFileName() {
        return "linkedin-skill.csv";
    }

    @Override
    public String[] getColumnHeaders() {
        return new String[]{"id", "displayName"};
    }

    @Override
    public CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(), // skill id
                new NotNull(), // skill name
        };
        return processors;
    }
}
