package ch.hslu.oop.sw11.io;


import ch.hslu.oop.sw11.temperature.DefaultTemperatureSequence;
import ch.hslu.oop.sw11.temperature.Temperature;
import ch.hslu.oop.sw11.temperature.TemperatureSequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class TemperatureBinaryWriter {
    public static final Logger LOG = LoggerFactory.getLogger(TemperatureBinaryWriter.class);
    public static final File FILE = new File("src/main/resources/sw11/temperatures.dat");

    public static void write(TemperatureSequence temperatures) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE)))) {
            var numberCount = temperatures.getItems().size();
            out.writeInt(numberCount);
            for (int i = 0; i < numberCount; i++) {
                out.writeFloat(temperatures.getItems().get(i).getKelvin());
            }
            out.flush();
        } catch (FileNotFoundException e) {
            LOG.error("File: ${} not found", FILE);
        } catch (IOException e) {
            LOG.error("Error while writing file", e);
        }
    }

    public static TemperatureSequence read() {
        var temps = new DefaultTemperatureSequence();
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE)))) {
            var numberCount = in.readInt();
            for (int i = 0; i < numberCount; i++) {
                var kelvin = in.readFloat();
                temps.add(Temperature.createFromKelvin(kelvin));
            }

        } catch (FileNotFoundException e) {
            LOG.error("File: ${} not found", FILE);
        } catch (IOException e) {
            LOG.error("Error while reading file", e);
        }
        return temps;
    }
}
