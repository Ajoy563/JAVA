public class BinaryToDecimal {
    public static int binaryToDecimal(int num){
        int deci = 0;
        int power = 0;
        int temp = num;
        while(temp > 0) {
            int digit = temp % 10;
            deci += digit * Math.pow(2, power);
            power++;
            temp /= 10;
        }
        return deci;
    }
    public static void main(String[] args)
    {
        int num = 10101001;
        System.out.println(binaryToDecimal(num));
    }
}
