package arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class demo {
    public static void main(String[] args) {

        List<String> arrayList = new ArrList<>();
//        the differenc between ArrayList<String> new ArrayList<>();
//        it allows the application to change the implementation very easily, since it is presumed that the only operations used are those specified by the interface.

        for (String s: new String[] {"aa", "bbbb", "cccc"}){
            System.out.println(arrayList.add(s));
        }
        System.out.println("the size is " + arrayList.size());

        System.out.println(arrayList);// implicted use toString()

        // explicit iterator()
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }


//        implict iterator()
//        for (String s: arrayList){
//            System.out.println(s);
//        }

        System.out.println("get(2) " + arrayList.get(2));
        System.out.println();
        System.out.println("set(0)" + arrayList.set(0, "AAAAAAA"));
        System.out.println();
        System.out.println("afterward" + arrayList);
        System.out.println();
        arrayList.add(2, "DDD");
        System.out.println("after L.add(2,\"DDD\"): " + arrayList);
// add element at the end
     arrayList.add(arrayList.size(),"YYYY");
        arrayList.add(arrayList.size(),"YYYY");
        arrayList.add(6,null);
     System.out.println(arrayList);

     System.out.println("the last index of \"YYYY\" " + arrayList.lastIndexOf(null));

     ListIterator<String> listIterator = arrayList.listIterator();
     while (listIterator.hasNext()){
         String s = listIterator.next();
         System.out.println(s);
     }






    }
}
