public class BintoDec {
    public static void BinToDecimal(int BinNum) {
        int MyNum = BinNum;
        int dec = 0;
        int pow = 0;
        while(BinNum > 0) {
            int Lastdigit = BinNum % 10;
            dec += Lastdigit * (int) Math.pow(2, pow);
            pow++;
            BinNum = BinNum / 10;
        }
        System.out.println("Decimal number of "+MyNum+" = "+dec);
    }
    public static void main(String args[]) {
        BinToDecimal(11111);
    }
}
