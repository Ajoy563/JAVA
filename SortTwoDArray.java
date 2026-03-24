import java.util.Arrays;
import java.util.Comparator;

public class SortTwoDArray {
    public static void print2DArray(int activities[][]) {
        for(int i=0; i<activities.length; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(activities[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //Here, the array is unsorted. First we have to sort
        int start[] = {0, 1, 3, 5, 5, 8};
        int end[] = {6, 2, 4, 7, 9, 9};

        //In activities array, we have 3 columns - index, start and end
        int activities[][] = new int[start.length][3];

        for(int i=0; i<start.length; i++) {
            activities[i][0] = i; //0 - index
            activities[i][1] = start[i]; //1 - start times
            activities[i][2] = end[i]; //0 - end times
        }
        print2DArray(activities);

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        System.out.println("Sorted on the basis of column 3");
        print2DArray(activities);
    }
}
