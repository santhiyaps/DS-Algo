package wf;

import java.util.*;

public class ResourceLogs {
    public static Map<String, List<Integer>> getMinMaxAccessTimestampForUsers(String[][] logs) {
        Map<String,List<Integer>>timeMap=new HashMap<>();
        for(String logEntry[]:logs){
            int time=Integer.parseInt(logEntry[0]);
            if(!timeMap.containsKey(logEntry[1])){
                timeMap.put(logEntry[1],new ArrayList<>(Arrays.asList(time,time)));
            }else{
                if(time< timeMap.get(logEntry[1]).get(0)){
                    timeMap.get(logEntry[1]).set(0,time);
                }
                if(time> timeMap.get(logEntry[1]).get(1)){
                    timeMap.get(logEntry[1]).set(1,time);
                }
            }
        }
        return timeMap;

    }
    public static String[] getMostRequestedResourceIn5Mins(String[][] logs) {
        Map<String,List<Integer>>timeMap=new HashMap<>();
        for(String logEntry[]:logs){
            int time=Integer.parseInt(logEntry[0]);
            if(!timeMap.containsKey(logEntry[2])){
                timeMap.put(logEntry[2],new ArrayList<>());
            }
            timeMap.get(logEntry[2]).add(time);
        }
        int max=0;
        String resource="";
        for(String key:timeMap.keySet()){
            List<Integer> list= timeMap.get(key);
            Collections.sort(list);
            int i = 0, j = 1;
            while(i<list.size() && j<list.size()) {
                int diff = list.get(j) - list.get(i);
                if (diff == 300) {
                    int index = (j - i) + 1;
                    if (index > max) {
                        max = j - i + 1;
                        resource=key;
                    }
                } else if (diff > 300) {
                    i++;
                }
                j++;
            }
        }
        return new String[]{resource,max+""};
    }

    public static void main(String[] args) {
        String[][] logs = new String[][]{
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][]{
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

       // System.out.println(getMinMaxAccessTimestampForUsers(logs));
        System.out.println("==========================================================================================");
        System.out.println( Arrays.toString(getMostRequestedResourceIn5Mins(logs2)));
        System.out.println("==========================================================================================");
        // buildTransitionMapWithProbabilities(logs);
    }
}

