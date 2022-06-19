package TreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class demo1 {
    public static void main(String[] args) {
        Comparator<String> cmp = new Comparator<String>() {


            public int compare(String lhs, String rhs) {
                String lhs_str = String.valueOf(lhs.length());
                String rhs_str = String.valueOf(rhs.length());
                return lhs_str.compareTo(rhs_str);
            }
        };

        Set<String> str_set = new TreeSet<>();
        Set<Integer> int_set = new TreeSet<>();
        Set<String> int_set_lex = new TreeSet<>(cmp);

//    Set<Integer> int_set_lex = new SearchTreeSet<Integer>(cmp);
//    Set<String> str_set = new SearchTreeSet<>();
//    Set<Integer> int_set = new SearchTreeSet<Integer>();

        System.out.println("add \"mm\": " + str_set.add("mm"));
        System.out.println("add \"mm\": " + str_set.add("mm"));

        for (String s : new String[]{"aa", "xx", "dd", "pp", "cc", "qq", "nn"}) {
            str_set.add(s);
        }

        System.out.println(str_set);

        System.out.println("remove \"mm\": " + str_set.remove("mm"));
        System.out.println(str_set);

        System.out.println();

        int[] samples = {10, 5, 15, 6, 19, 33, 4, 2};

        for (int i : samples) {
            int_set.add(i);
        }
        System.out.println("int_set: " + int_set);

        for (String s : new String[]{"aaaaaaaa", "bbbbb", "cccc","dddd", "e"}) {
            int_set_lex.add(s);
        }
        System.out.println("int_set_lex: " + int_set_lex);
    }
}
