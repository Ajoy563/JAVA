public class DecimalToBinary {
    public static void main(String args[]) {
        int decimal = 13;
        if(decimal == 0) 
            System.out.println("Binary: " + decimal);

        StringBuilder ans = new StringBuilder();
        while (decimal > 0) {
            ans.append(decimal % 2);
            decimal /= 2;
        }
        System.out.println("Binary: " + ans.reverse());
    }
}
