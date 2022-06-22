package TreeSet;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        SearchTreeSet<Integer> tree = new SearchTreeSet<Integer>();
        List<Integer> list = new ArrayList<>();

        int num_samples = 10;

        Random rand = new Random();
        for (int i = 0; i < num_samples; ++i) {
            int n = rand.nextInt(2 * num_samples);
            list.add(n);
            tree.add(n);
        }

        System.out.println("-------- reverse inorder --------");
        tree.reverseInorderOutput();

        System.out.println("-------- preorder --------");
        tree.preorderOutput();

        System.out.println("-------- postorder --------");
        tree.postorderOutput();

        int pos = rand.nextInt(num_samples);

        // pos = 0;  // use this to remove the root element

        int num = list.get(pos);

        System.out.println("remove: " + num);
        tree.remove(num);

        System.out.println("---------------");
        tree.reverseInorderOutput();
        System.out.println("---------------");
    }
    }






