package pattern.twopointer;

public class MoveDuplicate {

    /*Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
    after removing the duplicates in-place return the length of the subarray that has no duplicate in it.*/
    public static int remove(int[] arr) {
        int start=1;
        for(int i=1;i<arr.length;i++){
            if(arr[start-1]!=arr[i]){
                arr[start]=arr[i];
                start++;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new MoveDuplicate().remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
    }
}
