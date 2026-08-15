
import java.util.*;

public class test {

    public static void main(String args[]) {
        int[] a = { 1, 2, 3, 2, 4, 3, 5 };

        HashSet<Integer> set = new HashSet<>();

        for (int x : a) {
            if (!set.add(x))
                System.out.println(x + " === ");

        }
    }
}
