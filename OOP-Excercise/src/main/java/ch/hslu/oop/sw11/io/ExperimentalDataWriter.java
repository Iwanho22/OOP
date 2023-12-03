package ch.hslu.oop.sw11.io;

import java.io.*;

public class ExperimentalDataWriter {

    public static final File FILE = new File("src/main/resources/sw11/output.dat");

    public void writeNumber(int number) {
        try (var outputStream = new DataOutputStream(new FileOutputStream(FILE))) {
            outputStream.writeInt(number);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int readNumber() {
        int val = 0;
        try (var inputStream = new DataInputStream(new FileInputStream(FILE))) {
            val = inputStream.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return val;
    }

    public void writeString(String string) {
        try (var outputStream = new DataOutputStream(new FileOutputStream(FILE))) {
            outputStream.writeChars(string);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readAndWriteMultiple(double doubleToWrite, int numberToWrite) {
        var resultAsString = "";
        try (var outputStream = new DataOutputStream(new FileOutputStream(FILE))) {
            outputStream.writeDouble(doubleToWrite);
            outputStream.writeInt(numberToWrite);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var inputStream = new DataInputStream(new FileInputStream(FILE))) {
            resultAsString += "Double value: " + inputStream.readDouble() + ",";
            resultAsString += "Int value: " + inputStream.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultAsString;
    }
}
