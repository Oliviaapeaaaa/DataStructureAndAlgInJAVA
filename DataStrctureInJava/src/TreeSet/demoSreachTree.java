package TreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class demoSreachTree {
    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              String lhs = o1.toString();
              String rhs = o2.toString();
              return lhs.compareTo(rhs);
            }
        };

        Set<Integer> int_tree = new SearchTreeSet<Integer>(cmp);
        Set<Integer> int_set = new TreeSet<>();
        int[] samples = {10, 5, 15, 6, 19, 33, 4, 2};

        for (int i : samples) {
            int_set.add(i);
        }
        System.out.println("int_set: " + int_set);



    }



}
