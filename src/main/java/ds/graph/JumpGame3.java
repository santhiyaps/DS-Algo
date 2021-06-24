package ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue=new LinkedList<>();
        boolean visited[]=new boolean[arr.length];
        queue.add(start);
        while(!queue.isEmpty()){
            int curr=queue.poll();
            if(arr[curr]==0)
                return true;
            if(visited[curr])
                continue;
            if(curr-arr[curr]>=0)
                queue.add(curr-arr[curr]);
            if(curr+arr[curr]<arr.length)
                queue.add(curr+arr[curr]);
            visited[curr]=true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame3().canReach(new int[]{4,2,3,0,3,1,2},5));
    }
}
