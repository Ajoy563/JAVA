//Greedy Approach
// Given an array of jobs where every job has a deadline and profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

// Job A = 4, 20
// Job B = 1, 10     ans = C, A
// Job C = 1, 40
// Job D = 1, 30

import java.util.*;

public class JobSequencing { //TC - O(n), SC - O(n)
    static class Job {
        int deadline, id, profit;
        
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // for(Job j : jobs) 
        //     System.out.println(j.id + " " + j.deadline + " " + " " + j.profit);

        //Here, we sort on the basis of objects.
        // Collections.sort(jobs, (obj1, obj2) -> obj1.profit - obj2.profit); //asc order
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); //desc order
        
        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        int profit = 0;
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time) {
                seq.add(curr.id);
                time++;
                profit += curr.profit;
            }
        }
        System.out.println("Maximum Profit is = " + profit);
        System.out.print("Jobs selected: ");
        for (Integer integer : seq) {
            char c = (char)(integer + 'A');
            System.out.print("JOB " + c + " ");
        }
    }
}

