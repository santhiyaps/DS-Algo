package wf;

import java.util.*;

public class Zero3Parent {
    public static int[][] findZero3Parents(int[][]nodes){
        HashMap<Integer,List<Integer>>nodeMap=new HashMap<>();
        for(int[]node:nodes){
            if(!nodeMap.containsKey(node[0]))
                nodeMap.put(node[0],new ArrayList<>());
            if(!nodeMap.containsKey(node[1]))
                nodeMap.put(node[1],new ArrayList<>());
            nodeMap.get(node[1]).add(node[0]);
        }
        List<Integer>zeroList=new ArrayList<>();
        List<Integer>threeList=new ArrayList<>();
        for(Integer key:nodeMap.keySet()){
            if(nodeMap.get(key).size()==0)
                zeroList.add(key);
            else if(nodeMap.get(key).size()==3)
                threeList.add(key);
        }
        int[][] returnArr=new int[2][];
        returnArr[0]=new int[zeroList.size()];
        returnArr[1]=new int[threeList.size()];
        for(int i=0;i<zeroList.size();i++){
            returnArr[0][i]=zeroList.get(i);
        }
        for(int i=0;i<threeList.size();i++){
            returnArr[1][i]=threeList.get(i);
        }
        return returnArr;
    }

    public static int[] commonAncestors(int node1,int node2,int[][]nodes){
        HashMap<Integer,List<Integer>>nodeMap=new HashMap<>();
        for(int[]node:nodes){
            if(!nodeMap.containsKey(node[0]))
                nodeMap.put(node[0],new ArrayList<>());
            if(!nodeMap.containsKey(node[1]))
                nodeMap.put(node[1],new ArrayList<>());
            nodeMap.get(node[1]).add(node[0]);
        }
        Set<Integer>path1=findPath(nodeMap,node1);
        Set<Integer>path2=findPath(nodeMap,node2);
        List<Integer>list=new ArrayList<>();
        for(int i: path1){
            if(path2.contains(i))
                list.add(i);
        }
       int[]returnArr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            returnArr[i]=list.get(i);
        }
        return returnArr;

    }
    private static Set findPath(HashMap<Integer,List<Integer>>nodeMap,int node1){
        Queue<Integer>queue=new LinkedList<>();
        queue.add(node1);
        Set<Integer>path=new HashSet<>();
        while(!queue.isEmpty()){
            int n=queue.poll();
            path.add(n);
            for(int i:nodeMap.get(n)){
                queue.add(i);
            }
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] nodes=new int[15][2];
        nodes[0]=new int[]{11,1};
        nodes[1]=new int[]{1,2};
        nodes[2]=new int[]{2,5};
        nodes[3]=new int[]{3,5};
        nodes[4]=new int[]{1,4};
        nodes[5]=new int[]{4,0};
        nodes[6]=new int[]{4,13};
        nodes[7]=new int[]{4,9};
        nodes[8]=new int[]{13,6};
        nodes[9]=new int[]{9,6};
        nodes[10]=new int[]{11,7};
        nodes[11]=new int[]{7,15};
        nodes[12]=new int[]{19,15};
        nodes[13]=new int[]{5,8};
        nodes[14]=new int[]{7,5};
        int[][]arr=findZero3Parents(nodes);
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(commonAncestors(9,5,nodes)));
    }
}
