package wf;

import java.util.*;

public class ZeroOneParent {
    public List<Integer> findNode(List<int[]> relationships){
        List<Integer>result=new ArrayList<>();
        Map<Integer,Integer>nodeMap=new HashMap<>();
        for(int[]relation:relationships){
            if(!nodeMap.containsKey(relation[0]))
                nodeMap.put(relation[0],0);
            if(!nodeMap.containsKey(relation[1]))
                 nodeMap.put(relation[1],0);
            nodeMap.put(relation[1],nodeMap.get(relation[1])+1);
        }
        for(Integer key:nodeMap.keySet()){
            if(nodeMap.get(key)<=1)
                result.add(key);
        }
        return result;
    }

    public static int commonParent(List<int[]>arr,int node1,int node2){
        Map<Integer,List<Integer>>nodeMap=new HashMap<>();
        for(int[]relation:arr){
            if(!nodeMap.containsKey(relation[0]))
                nodeMap.put(relation[0],new ArrayList<>());
            if(!nodeMap.containsKey(relation[1]))
                nodeMap.put(relation[1],new ArrayList<>());
            nodeMap.get(relation[1]).add(relation[0]);
        }
        Set<Integer>path1=getParents(nodeMap,node1);
        Set<Integer>path2=getParents(nodeMap,node2);
        for(int i:path1){
            if(path2.contains(i))
                return i;
        }
      return -1;
    }
    private static Set<Integer>getParents(Map<Integer,List<Integer>>nodeMap,int node1){
        Set<Integer>path=new HashSet<>();
        Queue<Integer>queue=new LinkedList<>();
        queue.add(node1);
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
        List<int[]>nodes=new ArrayList<>();
        nodes.add(new int[]{11,1});
        nodes.add(new int[]{1,2});
        nodes.add(new int[]{2,5});
        nodes.add(new int[]{3,5});
        nodes.add(new int[]{1,4});
        nodes.add(new int[]{4,0});
        nodes.add(new int[]{4,13});
        nodes.add(new int[]{4,9});
        nodes.add(new int[]{13,6});
        nodes.add(new int[]{9,6});
        nodes.add(new int[]{11,7});
        nodes.add(new int[]{7,15});
        nodes.add(new int[]{19,15});
        nodes.add(new int[]{5,8});
        ZeroOneParent obj=new ZeroOneParent();
        List<Integer>result= obj.findNode(nodes);
        System.out.println(commonParent(nodes,9,0));



    }
}
