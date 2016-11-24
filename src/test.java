/**
 * Created by Teb0ho on 2016-10-10.
 */


public class test {

    public static void main(String[] args) {
        int[] a = new int[10];

        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }

        for (int x : a) {

            System.out.println("Print is now: " + x);

        }
    }
}
