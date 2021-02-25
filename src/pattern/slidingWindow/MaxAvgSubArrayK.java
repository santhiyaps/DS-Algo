package pattern.slidingWindow;

public class MaxAvgSubArrayK {
    public static double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        int start=0,end=0;
        double sum=0;
        while(end<nums.length){
            sum+=nums[end];
            if(end>=k-1){
                double avg=(double)sum/k;
                max=Math.max(max,avg);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxAvgSubArrayK.findMaxAverage(new int[] { -1 },1));
    }
}
