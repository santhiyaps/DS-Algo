package pattern.slidingWindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

   /* Given an array, find the average of all contiguous subarrays of size ‘K’ in it.*/

    public  double[] findAverages(int k, int[] arr) {
        double[]avg=new double[arr.length-k+1];
        int start=0,end=0;
        int sum=0;
        while(end<arr.length){
            sum+=arr[end];
            if(end>=k-1){
                avg[start]=(double)sum/k;
                sum-=arr[start];
                start++;
            }
            end++;
        }

     return avg;
    }

    public static void main(String[] args) {
        AverageOfSubarrayOfSizeK averageOfSubarrayOfSizeK=new AverageOfSubarrayOfSizeK();
        double[] result = averageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }


}
