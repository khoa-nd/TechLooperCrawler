package com.techlooper.storage.linkedin;

import com.techlooper.model.linkedin.LinkedInSkill;
import com.techlooper.storage.impl.CsvDataStorage;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Created by NguyenDangKhoa on 6/29/15.
 */
public class LinkedInJobTitleCsvDataStorage extends CsvDataStorage<LinkedInSkill> {

    @Override
    public String getFileName() {
        return "linkedin-jobTitle.csv";
    }

    @Override
    public String[] getColumnHeaders() {
        return new String[]{"id", "displayName"};
    }

    @Override
    public CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(), // job title id
                new NotNull(), // job title name
        };
        return processors;
    }
}
