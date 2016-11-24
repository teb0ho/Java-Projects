/**
 * Created by Teb0ho on 2016-09-16.
 */
import java.util.ArrayList;
import java.util.Random;

public class lot_test {

    public static void main (String args []) {

        ArrayList<Integer> num = new ArrayList<Integer>();
        Random ballpicker = new Random();

        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);


        int hh = ballpicker.nextInt(45);


        if (!(num.contains(hh) && num.get(0).equals(1))) {
            System.out.println("Passed");
        }

        System.out.println(num.contains(hh));
        System.out.println(hh);


        //System.out.println("Hello, 世界");
    }
}
