package pattern.slidingWindow;

public class MinSizeSubArraySum {
    /*Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
    Return 0 if no such subarray exists.*/
    public static int findMinSubArray(int S, int[] arr) {
     int start=0,end=0;
     int sum=0;
     int minSub=Integer.MAX_VALUE;
     while(end<arr.length){
         sum+=arr[end];
        while(sum>=S){
             minSub=Math.min(minSub,(end-start)+1);
             sum-=arr[start];
             start++;
         }
         end++;
     }
     return minSub;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7,new int[]{2, 1, 5, 2, 3, 2}));
    }
}
