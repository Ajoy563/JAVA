
public class test {
    public static void bubbleSort(int arr[], int n) {
        for(int i=0; i < n - 1; i++) {
            boolean swapped = false;
            for(int j=0; j< n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                swapped = true;
            }
            if(!swapped)
                break;
        }
    }
    public static void selectionSort(int arr[], int n) {
        for(int i=0; i<n-1; i++) {
            int minidx = i;
            for(int j = i + 1; j<n; j++) {
                if(arr[j] < arr[minidx]) {
                    minidx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minidx];
            arr[minidx] = temp;
        }
    }
    public static void insertionSort(int arr[], int n) {
        for(int i=1; i<n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int pivotIdx = partition(arr, low, high);

            partition(arr, low, pivotIdx-1);
            partition(arr, pivotIdx+1, high);
        }
    }
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low ; j<high; j++) {
            if(arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void main(String[] args) {
        int[] arr = {9, 25, 12, 22, 11};
        int n = arr.length;
        // bubbleSort(arr, n);
        // selectionSort(arr, n);
        // insertionSort(arr, n);
        quickSort(arr, 0, n-1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
