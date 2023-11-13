package ch.hslu.oop.sw09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                var temp =  Temperature.createFromCelsius(value);
                LOG.info(temp.toString());
            } catch (NumberFormatException e) {
                LOG.error("Fehler beim konvertieren der Temperatur -> Eingabe ist keine Zahl");
            }
        } while (!"exit".equals(input));
        System.out.println("Programm beendet.");


    }
}
