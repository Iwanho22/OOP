package ch.hslu.oop.sw10.temperature;

import ch.hslu.oop.sw10.temperature.event.TemperatureChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        String input = "";
        Scanner scanner = new Scanner(System.in);
        var tempSequence = new DefaultTemperatureSequence();
        tempSequence.addTemperatureChangeListener(Main::handleTemperatureChangEvent);

        while (!"exit".equals(input)) {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                var temp =  Temperature.createFromCelsius(value);
                tempSequence.add(temp);
                LOG.warn(temp + " added");
            } catch (NumberFormatException e) {
                LOG.error("Fehler beim konvertieren der Temperatur -> Eingabe ist keine Zahl");
            }
        }
        LOG.info("Total of temperatures: " + tempSequence.getCount());
        LOG.info("Min-temperature: " + tempSequence.min());
        LOG.info("Max-temperature: " + tempSequence.max());
        System.out.println("Programm beendet.");


    }

    private static void handleTemperatureChangEvent(TemperatureChangeEvent e) {
        switch (e.getTemperatureChangeState()){
            case NEW_MAX -> LOG.info("New Max-Temperature: " + e.getNewTemperature());
            case NEW_MIN -> LOG.info("New Min-Temperature: " + e.getNewTemperature());
        }
    }
}
