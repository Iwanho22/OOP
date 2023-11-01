package ch.hslu.oop.sw03;

public class Iteration {
    public static String print1To10() {
        String printout = "";
        for(int i = 1; i <= 10; i++) {
            printout += i + "\n";
        }
        System.out.println(printout);
        return printout;
    }

    public static void printBox(final int width, final int height) {
        for (int i = 0; i < height; i++) {
            String line = "";
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height -1 || j == 0 || j == width - 1) {
                    line += "#";
                } else {
                    line += " ";
                }
            }
            System.out.println(line);
        }
    }
}
