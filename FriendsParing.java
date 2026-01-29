public class FriendsParing {
    public static int pair(int n) {
        int totalway = n;
        if(n == 1 || n == 2) {
            return totalway;
        }
        int p = n/2;
        return totalway+p;
    }
    public static void main(String args[]) {
        int n = 3;
        System.out.println(pair(n));
    }
}
