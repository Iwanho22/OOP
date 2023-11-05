package ch.hslu.oop.sw07;

import java.util.Comparator;
import java.util.Objects;

final public class Person implements Comparable<Person> {
    private final long id;
    private String name;
    private String surname;

    public Person(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return STR. """
                ID: \{ this.id }!
                Name: \{ this.name }!
                Surname: \{ this.surname }!""" ;
    }

    @Override
    public int compareTo(Person person) {
        return Long.compare(id, person.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        return (obj instanceof Person p)
                && Objects.equals(p.id, this.id)
                && Objects.equals(p.name, this.name)
                && Objects.equals(p.surname, this.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.surname);
    }
}
