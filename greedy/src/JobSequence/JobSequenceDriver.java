package JobSequence;

import java.util.Arrays;
import java.util.Map;

public class JobSequenceDriver {
    public static void main(String[] args) {

        Job[] jobs = new Job[]{new Job(1,4,20),new Job(2,1,10), new Job(3,1,40),new Job(4,1,30)};
        System.out.println(Arrays.toString(new Solution().JobScheduling(jobs,4)));
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {

        Arrays.sort(arr,((o1, o2) -> o2.profit-o1.profit));

        int maxDeadLine = Integer.MIN_VALUE;
        for (Job job : arr){
            maxDeadLine = Math.max(maxDeadLine,job.deadline);
        }

        int[] schedule = new int[maxDeadLine];
        for (int i = 0; i < maxDeadLine; i++) {
            schedule[i] = -1;
        }

        int count = 0;
        int totalProfit = 0;
        for (int i = 0; i < n; i++) {

            Job job = arr[i];
            for (int j = job.deadline-1; j >=0 ; j--) {
                if(schedule[j] == -1){
                    count++;
                    schedule[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        return new int[]{count,totalProfit};

    }
}