package Easy;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 3, 5, 0, 7, 0, 6, 2};
        // int right = arr.length - 1;
            //Two pointers approach
            
        // for(int left=0; left<right; left++) {
        //     if(arr[left] == 0 && arr[right] != 0) {
        //         int temp = arr[left];
        //         arr[left] = arr[right]; 
        //         arr[right] = temp;
        //         right--;
        //     }
        //     else if(arr[left] != 0 && arr[right] != 0) {
        //         continue;
        //     }

        //     else if(arr[right] == 0) {
        //         right--;
        //     }
        // }

        int index = 0;
        for(int i=0; i< arr.length; i++) {
            if(arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
