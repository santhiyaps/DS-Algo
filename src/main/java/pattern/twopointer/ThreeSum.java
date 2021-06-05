package pattern.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            int left=i+1;
            int right=arr.length-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==0){
                    List<Integer>nums=new ArrayList<Integer>();
                    nums.add(arr[i]);
                    nums.add(arr[left]);
                    nums.add(arr[right]);
                    if(!triplets.contains(nums)){
                        triplets.add(nums);
                    }
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }
            }
        }
        return triplets;
    }
}
