package ch.hslu.oop.sw08;

import java.util.List;

public interface Sequence<T> {

    void add(T temperature);

    int getCount();

    T max();

    T min();

    List<T> getItems();

    void clear();
}
