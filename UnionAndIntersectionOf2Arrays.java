import java.util.*;
public class UnionAndIntersectionOf2Arrays {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        //Union - O(n + m) ~ O(n)
        for(Integer i : arr1) {
            set.add(i);
        }
        for(Integer i : arr2) {
            set.add(i);
        }
        System.out.print("Union = " + set.size() + " ( ");

        for(Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.print(")");

        //Intersection - O(n + m) ~ O(n)
        set.clear();
        for(Integer i : arr1) {
            set.add(i);
        }
        int count = 0;
        String str = "";
        for(Integer i : arr2) {
            if(set.contains(i)) {
                count++;
                str+=i+" ";
                set.remove(i);
                
            }
        }
        System.out.print("\nIntersection = " + count);
        System.out.print(" ( " + str + ")");
    }
}
