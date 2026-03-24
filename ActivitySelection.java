//Greedy Approach

// You are given n activities with their start and end times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time. Activities are sorted according to end time.

// start = [10, 12, 20]
// end = [20, 25, 30].                       // ans = 2 (AO & A2)

import java.util.*;
public class ActivitySelection {
    public static void print2DArray(int activities[][]) {
        for(int i=0; i<activities.length; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(activities[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void sortedActivity() {
        System.out.println("----For Sorted time----");
        //Here, the array is sorted on the basis of end time
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        ArrayList<Integer> idx = new ArrayList<>();
        int maxAct = 1;
        idx.add(0);
        int lastEnd = end[0];

        for(int i=1; i<start.length; i++) {
            if(start[i] >= lastEnd) {
                maxAct++;
                idx.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum activitity selected: " + maxAct);
        for(int i=0; i<idx.size(); i++) {
            System.out.print("A" + idx.get(i) + " ");
        }
        System.out.println();

    }

    public static void unsortedActivity() {
        System.out.println("----For Unsorted time----");
        System.out.println();
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
        print2DArray(activities);

        ArrayList<Integer> idx = new ArrayList<>();
        int maxAct = 1;
        idx.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i=1; i<start.length; i++) {
            if(activities[i][1] >= lastEnd) {
                maxAct++;
                idx.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum activitity selected: " + maxAct);
        for(int i=0; i<idx.size(); i++) {
            System.out.print("A" + idx.get(i) + " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        sortedActivity();
        unsortedActivity();
    }
}
