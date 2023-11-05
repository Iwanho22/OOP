package ch.hslu.oop.sw07;


import java.util.Comparator;
import java.util.Objects;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        var compare = o1.getSurname().compareTo(o2.getSurname());
        if (compare == 0) {
            compare = o1.getName().compareTo(o2.getName());
        }
        return compare;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Person.class);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PersonNameComparator;
    }
}
