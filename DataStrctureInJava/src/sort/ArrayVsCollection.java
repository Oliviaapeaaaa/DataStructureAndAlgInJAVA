package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayVsCollection {
    static class Person
//          implements Comparable<Person>
    {
        String name;
        Integer id;

        public Person(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("(%s,%s)", name, id);
        }

//    @Override
//    public int compareTo(Person p) {
//      return id.compareTo(p.id);
//    }
//
//    @Override
//    public int compareTo(Person p) {
//      return name.compareTo(p.name);
//    }
    }

    public static void main(String[] args) {
        Person[] persons = new Person[] {
                new Person("Joe", 666),
                new Person("Mary", 555),
                new Person("Laura", 333),
                new Person("Jill", 444),
        };

        List<Person> personList = Arrays.asList(persons);

        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person first, Person second) {
                return first.id.compareTo(second.id);
                //return first.name.compareTo(second.name);
            }
        };

        System.out.println("before: " + personList);

//         1. run-time failure unless "Comparable"
//    Arrays.sort(persons);
//    System.out.println("after:  " + Arrays.toString(persons));

        // 2. compile-time failure unless "Comparable"
//    Collections.sort(personList);
//    System.out.println("after:  " + personList);

        // 3. Arrays.sort with comparator
    Arrays.sort(persons, comp);
    System.out.println("after:  " + Arrays.toString(persons));

        // 4. Collections.sort with comparator
    Collections.sort(personList, comp);
    System.out.println("after:  " + personList);
    }
}
