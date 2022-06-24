package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class stableSort {
    static class Email {

        String from;
        Date time;

        Email(String from, Date time) {
            this.from = from;
            this.time = time;
        }

        @Override
        public String toString() {
            return from + " : " + time;
        }
    }

    public static void main(String[] args) {

        Email E[] = new Email[]{
                new Email("bob", new GregorianCalendar(2008, 10, 19).getTime()),
                new Email("john", new GregorianCalendar(2008, 10, 15).getTime()),
                new Email("steve", new GregorianCalendar(2008, 10, 14).getTime()),
                new Email("john", new GregorianCalendar(2008, 10, 18).getTime()),
                new Email("bob", new GregorianCalendar(2008, 10, 16).getTime()),
                new Email("bob", new GregorianCalendar(2008, 10, 12).getTime()),
                new Email("steve", new GregorianCalendar(2008, 10, 17).getTime()),
                new Email("john", new GregorianCalendar(2008, 10, 13).getTime())
        };

        Comparator<Email> cmp_from = new Comparator<Email>() {
            @Override
            public int compare(Email lhs, Email rhs) {
                return lhs.from.compareTo(rhs.from);
            }
        };

        Comparator<Email> cmp_time = new Comparator<Email>() {
            @Override
            public int compare(Email lhs, Email rhs) {
                return lhs.time.compareTo(rhs.time);
            }
        };

        System.out.println("----------------- before");
        for (Email e : E) {
            System.out.println(e);
        }

        Arrays.sort(E, cmp_time);  // sort by time

        System.out.println("----------------- sorted by time");
        for (Email e : E) {
            System.out.println(e);
        }

        Arrays.sort(E, cmp_from);  // sort by from

        System.out.println("----------------- sorted by from");
        for (Email e : E) {
            System.out.println(e);
        }
    }
}
