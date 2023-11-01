package ch.hslu.oop.sw03;

public class NumberComparator {

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max(int a, int b, int c) {
        return max(max(a,b),c);
    }
}
