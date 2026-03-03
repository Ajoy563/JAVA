
import java.util.*;
public class test {

    public static int maxArea(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for(int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : arr[i];

            while(!stack.isEmpty() && currHeight < arr[stack.peek()]) {
                int height = arr[stack.pop()];

                int width;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // int arr[] = {2, 1, 5, 6, 2, 3};
        int arr[] = {3, 5, 1, 2, 7, 4};
        int result = maxArea(arr);
        System.out.println("Maximum area is: " + result);
    }
}
