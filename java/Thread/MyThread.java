package Thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by zohn on 2017/12/21.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        testTreeset();
    }

    private static void testTreeset() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        for (Integer i : ts) {
            System.out.println(i + "----------------");
        }
    }

    static void collectionTest(){
        Collection  arr = new ArrayList();
    }
}
