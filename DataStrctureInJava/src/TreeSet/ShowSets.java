package TreeSet;

import java.util.*;

public class ShowSets {
    public static void main(String[] args) {
        Integer[] I = new Integer[20];
        Random r = new Random();
        for (int n = 0; n < I.length; ++n) {
            I[n] = r.nextInt(50);
        }

        Set<String> HS = new HashSet<>();
        Set<Integer> LS = new LinkedHashSet<>();
        Set<Integer> TS = new TreeSet<>();

        for (Integer n : I) {
            LS.add(n);
            TS.add(n);
        }
        System.out.println("Input Array:    " + Arrays.toString(I));
        System.out.println("Linked HashSet: " + LS);
        System.out.println("TreeSet:        " + TS);
        System.out.println("HashSet:        " + HS);
        String[] strings = {"music", "beer", "afterlife", "wisdom",
                "politics", "theater", "schools", "painting", "fear"};
        for (String s : strings) {
            HS.add(s);
        }
        System.out.println("HashSet:        " + HS);
    }
}
