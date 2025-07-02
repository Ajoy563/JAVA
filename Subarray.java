

public class Subarray {
    public static void prefixSubarray(int numbers[]) {
        int maximum = Integer.MIN_VALUE;
        int currSum;
        int Prefix[] = new int[numbers.length];
        Prefix[0] = numbers[0];
        for(int i=1; i<Prefix.length; i++) { // Calculate the maxSum of Subarrays
            Prefix[i] =  Prefix[i-1] + numbers[i];
        }

        for(int i=0; i<numbers.length; i++) {
            for(int j=i; j<numbers.length; j++) { 
                currSum = i == 0 ? Prefix[j] : Prefix[j] - Prefix[i-1];
                maximum = currSum > maximum ? currSum : maximum;
            }
        }
        System.out.println("The Maximum Sum is: " + maximum);

    }

    public static void maxSubarray(int numbers[]){
        int CurrSum;
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                 CurrSum = 0;
                for(int k=i; k<=j; k++) {
                    System.out.print(numbers[k] + " ");
                    CurrSum += numbers[k];
                }
                if(CurrSum > maximum) {
                    maximum = CurrSum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Maximum Sum of Subarray: " + maximum);
    }

    public static void printSubarray(int numbers[]) {
        int total = 0;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                int CurrSum = 0;
                for(int k=i; k<=j; k++) {
                    System.out.print(numbers[k] + " ");
                    CurrSum += numbers[k];
                }
                if(CurrSum > maximum) {
                    maximum = CurrSum;
                }
                if(CurrSum < minimum) {
                    minimum = CurrSum;
                }
                total++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total number of Subarray is: " + total);
        System.out.println("Maximum Sum of Subarray: " + maximum);
        System.out.println("Minimum Sum of Subarray: " + minimum);
    }
    public static void main(String args[]) {
        //int numbers[] = {2, 4, 6, 8, 10};
        int num[] = {1, -2, 6, -1, 3};
        //printSubarray(numbers);
        //maxSubarray(num);
        prefixSubarray(num);
    }
    
}
