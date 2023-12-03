package ch.hslu.oop.sw11.io;

import ch.hslu.oop.sw11.temperature.*;
import ch.hslu.oop.sw11.utils.DateTimeParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MeasurementCSVReader {
    public static final File MEASUREMENT_FILE = new File("src/main/resources/sw11/netatmo-export-202301-202304.csv");

    public static MeasurementSequence readFromCSV() {
        MeasurementSequence temperatures = new DefaultMeasurementSequence();
        if (MEASUREMENT_FILE.exists()) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(MEASUREMENT_FILE),
                    StandardCharsets.UTF_8))) {

                while (in.readLine() != null) {
                    var values = in.readLine().split(";");
                    temperatures.add(new TemperatureMeasurement(DateTimeParser.parseDate(values[1]),
                            Temperature.createFromCelsius(Float.parseFloat(values[2]))));
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return temperatures;
    }
}
