package ch.hslu.oop.sw08;

import java.util.*;

public abstract class AbstractSequence<T extends Comparable<T>> implements Sequence<T> {
    protected final List<T> items;

    public AbstractSequence() {
        items = new ArrayList<>();
    }

    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T max() {
        if (getCount() == 0) {
            throw new IllegalStateException();
        }
        return Collections.max(items);
    }

    @Override
    public T min() {
        if (getCount() == 0) {
            throw new IllegalStateException();
        }
        return Collections.min(items);
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public List<T> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(items);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        return (obj instanceof AbstractSequence sequence)
                && Objects.equals(items, sequence.items);
    }
}
