package GreedyApproach;


import java.util.Arrays;

class Activity {
    int start, end;
    Activity(int s, int e) {
        start = s;
        end = e;
    }
}
public class ActivitySelectionProblem {
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9)
        };

        Arrays.sort(activities, (a, b) -> {
            return a.start - b.start;
        });

        int[] dp = new int[activities.length];
        Arrays.fill(dp, 1);

        for(int i=0;i<activities.length;i++){
            for(int j=i+1;j<activities.length;j++){
                if(activities[i].end <= activities[j].start){
                    dp[j] = dp[i] + 1;
                }
            }
        }

        int max = 1;
        for(int ele: dp){
            max = Math.max(max, ele);
        }
        System.out.println(max);
    }
}
