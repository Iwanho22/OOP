package ch.hslu.oop.sw11;

import ch.hslu.oop.sw11.io.MeasurementCSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeasurementStatistics {
    public static final Logger LOG = LoggerFactory.getLogger(MeasurementStatistics.class);

    public static void main(String[] args) {
        var measurements = MeasurementCSVReader.readFromCSV();

        LOG.info("Average Temperature: {}", measurements.getAverageTemperature().toString());
        LOG.info("Max temperature: {}", measurements.max());
        LOG.info("Min temperature: {}", measurements.min());
    }
}
