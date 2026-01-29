import java.util.*;
public class JavaBasics {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data: ");
        float price = sc.nextFloat();
        System.out.println(price);
    }
}