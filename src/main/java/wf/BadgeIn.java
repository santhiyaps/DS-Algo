package wf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BadgeIn {
    public static void badgeIn(String[][] times) {
        HashMap<String, List<Integer>>userTimes=new HashMap<>();
        for(String time[]:times){
           if(!userTimes.containsKey(time[0]))
               userTimes.put(time[0],new ArrayList<Integer>());
           List<Integer>list=userTimes.get(time[0]);
           list.add(Integer.parseInt(time[1]));
        }
        for(String key:userTimes.keySet()){
            List<Integer>list=userTimes.get(key);
            Collections.sort(list);
            if(list.size()>2) {
                int i = 0, j = 1,startIndex=0,endIndex=0;
                int max=0;
                List<Integer>result=new ArrayList<>();
                while(i<list.size() && j<list.size()){
                    int diff=list.get(j)-list.get(i);
                    if(diff>=90 && diff<=100){
                        int index=(j-i)+1;
                        if(index>=3 && index>max){
                           startIndex=i;
                           endIndex=j;
                           max=j-i;
                        }
                    }else if(diff>100){
                        i++;
                    }
                    j++;
                }
                if(endIndex!=0) {
                    String resultTimes = "";
                    for (int k = startIndex; k <= endIndex; k++) {
                        resultTimes += list.get(k) + " ";
                    }
                    System.out.println(key +" "+ resultTimes.toString());
                }
            }

        }

    }

    public static void main(String[] args) {
        String times[][] = {{"Paul", "1355"},
                {"Jennifer", "1910"},
                {"John", "835"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "1615"},
                {"John", "1640"},
                {"Paul", "1405"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"},
                {"Jennifer", "5"}};
        badgeIn(times);

    }
}
