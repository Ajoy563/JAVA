
public class pattern {
    public static void HollowRhombus(int n){
        for(int i=1; i<=n; i++) {
            String sp = " ".repeat(n-i);
            String star = "*".repeat(5);
            String Hstar = "*   *";
            if (i == 1 || i == n) {
                System.out.println(sp+star);
            }
            else {
                System.out.println(sp+Hstar);
            }
        }
    }
    public static void Rhombus(int n) {
        for(int i=1; i<=n; i++) {
            String sp = " ".repeat(n-i);
            String star = "*".repeat(5);
            System.out.println(sp+star);
        }
    }
    public static void Butterfly(int n) {
        for(int i=1; i<=n; i++) {
            String star = " * ".repeat(i);
            String sp = "   ".repeat((2 *(n - i)));
            System.out.println(star+sp+star);
        }
        for(int i=n; i>=1; i--) {
            String star = " * ".repeat(i);
            String sp = "   ".repeat((2 *(n - i)));
            System.out.println(star+sp+star);
        }
    }
    public static void Triangle0_1(int n) {
        for(int i=1; i<=n ;i++){
            for(int j=1; j<=i; j++) {
                if((i + j) % 2 == 0) {
                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    public static void ABC(int n) {
        char ch = 'A';
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
    public static void Rec(int tolRows, int tolCols) {
        for(int i=1; i<=tolRows; i++) {
            for(int j=1; j<=tolCols; j++) {
                if(i==1 || i==tolRows || j==1 || j==tolCols) {
                    System.out.print(" * ");
                }
                else {
                    System.out.print("   " );
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        //ABC(5);
        //Rec(10, 10);
        //Triangle0_1(5);
        //Butterfly(4);
        //Rhombus(5);
        HollowRhombus(10);
    }
    
}
