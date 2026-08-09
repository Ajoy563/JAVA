package Pattern;
public class butterflyPattern {
    public static void main(String[] args) {
        int n = 7;
        for(int i=1; i<=n; i++) {
            System.out.print("*".repeat(i) + "");
            System.out.print(" ".repeat((2*n) - (2*i)));
            System.out.print("*".repeat(i));
            System.out.println();
        }
        for(int i=n; i>=1; i--) {
            System.out.print("*".repeat(i) + "");
            System.out.print(" ".repeat((2*n) - (2*i)));
            System.out.print("*".repeat(i));
            System.out.println();
        }
    }
}
