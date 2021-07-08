package wf;

import java.util.*;
import java.util.stream.Collectors;

public class PairCourses {
    private static void groupThem(String[][] arr){
        HashMap<String, Set<String>> courseIdMap=new HashMap<>();
        List<String> list=new ArrayList<>();
        for(String course []:arr){
            if(!courseIdMap.containsKey(course[0])){
                courseIdMap.put(course[0],new HashSet<>());
                list.add(course[0]);
            }
            courseIdMap.get(course[0]).add(course[1]);
        }
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                Set list1=courseIdMap.get(list.get(i));
                Set list2=courseIdMap.get(list.get(j));
                System.out.println(list.get(i)+","+list.get(j)+" ");
                System.out.println(list1.stream().filter(list2::contains).collect(Collectors.toList()));

            }
        }
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"},
        };

        groupThem(arr);
    }
}
