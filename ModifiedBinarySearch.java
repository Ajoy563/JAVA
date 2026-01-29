public class ModifiedBinarySearch {
    public static int Search(int arr[], int si, int ei, int tar) {
        //base case
        if(si > ei) {
            return -1;
        }
        int mid = si + (ei-si)/2;

        if(arr[mid] == tar) {  //Case found
            return mid;
        }
        //Case 1: mid on L1
        if(arr[si] <= arr[mid]) {

            //Case a : L1 left
            if(arr[si] <= tar && tar <= arr[mid]){
                return Search(arr, si, mid-1, tar);
            }
            else {
                //Case b : mid right
                return Search(arr, mid+1, ei, tar);
            }
        }

        // Case 2: mid on L2
        else {
            if(arr[mid] <= tar && tar <= arr[ei]) {
                //Case c : L2 right
                return Search(arr, mid+1, ei, tar);
            }
            else {
                //Case d : mid left
                return Search(arr, si, mid-1, tar);
            }
        }
    }
    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int tar = 0;
        int tarIdx = Search(arr, 0, arr.length-1, tar);
        if(tarIdx == -1) {
            System.out.println("Element not exit!");
        }
        else {
            System.out.println("Element found at " + tarIdx);
        }
    }
}
