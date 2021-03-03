package pattern.twopointer;

public class TargetSum {

   /* Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

    Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.*/
   public static int[] search(int[] arr, int targetSum) {
         int start=0,end=arr.length-1;
         while(start<end){
            int sum=arr[start]+arr[end];
            if(sum==targetSum)
               return new int[]{start,end};
            if(sum<targetSum)
               start++;
            else
               end--;
         }
      return new int[]{-1,-1};
   }

   public static void main(String[] args) {
      int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
      result = search(new int[] { 2, 5, 9, 11 }, 11);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
   }
}
