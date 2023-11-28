package ch.hslu.oop.sw11;

import java.io.*;
import java.util.Objects;

public class DataWriter {

    public void writeNumber(int number) {
        String file = "C:\\Users\\ivovo\\Documents\\HSLU\\PLAB\\OOP\\OOP-Excercise\\src\\main\\resources\\sw11\\output.dat";
        try (var outputStream = new DataOutputStream(new FileOutputStream(file))) {
            outputStream.writeInt(number);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int readNumber() {
        int val = 0;
        String file = "C:\\Users\\ivovo\\Documents\\HSLU\\PLAB\\OOP\\OOP-Excercise\\src\\main\\resources\\sw11\\output.dat";
        try (var inputStream = new DataInputStream(new FileInputStream(file))) {
            val = inputStream.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    public void writeString(String string) {
        String file = "C:\\Users\\ivovo\\Documents\\HSLU\\PLAB\\OOP\\OOP-Excercise\\src\\main\\resources\\sw11\\output.dat";
        try (var outputStream = new DataOutputStream(new FileOutputStream(file))) {
            outputStream.writeChars(string);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
