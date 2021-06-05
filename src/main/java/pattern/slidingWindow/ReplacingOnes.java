package pattern.slidingWindow;

public class ReplacingOnes {
    /*Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
    find the length of the longest contiguous subarray having all 1s.
     */
    public static int findLength(int[] arr, int k) {
        int start=0,end=0;
        int maxRepeat=0,count=0;
        while(end<arr.length){
            if(arr[end]==1)
                count++;
            while(end-start+1-count>k){
                if(arr[start]==1)
                    count--;
                start++;
            }
            maxRepeat=Math.max(end-start+1,maxRepeat);
            end++;
        }
        return maxRepeat;
    }
    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
