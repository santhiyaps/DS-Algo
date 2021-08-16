package fb;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWays {
    static int numberOfWays(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            int num = countMap.getOrDefault(i, 0) + 1;
            countMap.put(i, num);
        }
        for (int i=0;i<arr.length;i++) {
            if (countMap.containsKey(k - arr[i]))
                count += countMap.get(k - arr[i]);
            if (k - arr[i] == arr[i])
               count--;

        }
        return count / 2;

    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(new int[]{1,2,3,4,3},6));
        System.out.println(numberOfWays(new int[]{1,5,3,3,3},6));
    }
}
