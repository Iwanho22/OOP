package ch.hslu.oop.sw11;

import ch.hslu.oop.sw11.io.TemperatureBinaryWriter;
import ch.hslu.oop.sw11.temperature.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TemperatureReader {
    private static final Logger LOG = LoggerFactory.getLogger(TemperatureReader.class);

    public static void main(String[] args) {

        String input = "";
        Scanner scanner = new Scanner(System.in);
        var tempSequence = TemperatureBinaryWriter.read();
        tempSequence.addTemperatureExtremaListener(e -> LOG.info(e.toString()));

         do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            if (!"exit".equals(input)) {
                try {
                    float value = Float.parseFloat(input);
                    var temp = Temperature.createFromKelvin(value);
                    tempSequence.add(temp);
                    LOG.warn(temp + " added");
                } catch (NumberFormatException e) {
                    LOG.error("Fehler beim konvertieren der Temperatur -> Eingabe ist keine Zahl");
                }
            }
        } while (!"exit".equals(input));

        TemperatureBinaryWriter.write(tempSequence);

        LOG.info("Total of temperatures: " + tempSequence.getCount());
        LOG.info("Min-temperature: " + tempSequence.min());
        LOG.info("Max-temperature: " + tempSequence.max());
        System.out.println("Programm beendet.");
    }
}
