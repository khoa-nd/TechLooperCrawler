package com.techlooper.storage.impl;

import com.techlooper.storage.CrawlerDataStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by NguyenDangKhoa on 6/25/15.
 */
public abstract class CsvDataStorage<T> implements CrawlerDataStorage<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvDataStorage.class);

    @Override
    public void store(List<T> dataset) {
        ICsvBeanWriter beanWriter = null;
        try {
            beanWriter = new CsvBeanWriter(new FileWriter(getFileName(), true), CsvPreference.STANDARD_PREFERENCE);

            final CellProcessor[] processors = getProcessors();
            final String[] header = getColumnHeaders();

            beanWriter.writeHeader(header);

            for (T item : dataset) {
                beanWriter.write(item, header, processors);
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } finally {
            if (beanWriter != null) {
                try {
                    beanWriter.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    public abstract String getFileName();

    public abstract String[] getColumnHeaders();

    public abstract CellProcessor[] getProcessors();

}
