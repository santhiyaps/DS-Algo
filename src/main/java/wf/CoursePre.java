package wf;

import java.util.*;

public class CoursePre {
    public static void main(String[] args) {
        String[][] prereqs_courses1 = {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };
        String[][] prereqs_courses2 = {
                {"Data Structures", "Algorithms"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Foundations of Computer Science", "Logic"}
        };

        String[][] prereqs_courses3 = {
                {"Data Structures", "Algorithms"},
        };
      System.out.println(findMid(prereqs_courses1));
      System.out.println(findMid(prereqs_courses2));
      System.out.println(findMid(prereqs_courses3));

    }

    private static String findMid(String[][] courses) {
        Map<String, List<String>> courseMap=new HashMap<>();
        List<String>courseList=new ArrayList<>();
        Map<String,Integer>indegrees=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        for(String[] course:courses){
            indegrees.put(course[0],0);
            indegrees.put(course[1],0);
        }
        for(String[]course:courses){
            if(!courseMap.containsKey(course[0])){
                courseMap.put(course[0],new ArrayList<>());
            }
            List<String> list=courseMap.get(course[0]);
            list.add(course[1]);
            indegrees.put(course[1],indegrees.get(course[1])+1);
        }
        for(String key:indegrees.keySet()){
            if(indegrees.get(key)==0)
                queue.add(key);
        }
        while(!queue.isEmpty()){
            String course=queue.poll();
            courseList.add(course);
            if(courseMap.containsKey(course)) {
                for (String depcourse : courseMap.get(course)) {
                    indegrees.put(depcourse, indegrees.get(depcourse) - 1);
                    if (indegrees.get(depcourse) == 0)
                        queue.add(depcourse);
                }
            }
        }
        String midCourse="";
        if(courseList.size()>0){
            int mid=courseList.size()/2;
            if(courseList.size() ==2)
                midCourse=courseList.get(0);
            else if(courseList.size()%2==0)
                midCourse=courseList.get(mid-1);
            else
              midCourse= courseList.get(mid);
        }
        return midCourse;
    }
}
