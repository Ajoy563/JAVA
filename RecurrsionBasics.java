public class RecurrsionBasics {
    public static void printDec(int n) {
        if(n > 1) {
            System.out.print(n + " ");
            printDec(n-1);
        }
        else {
            System.out.print(n + " ");
        }
    }
    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }
    public static void main(String args[]) {
        //printDec(10);
        printInc(10);
    }
}
