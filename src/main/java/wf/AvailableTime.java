package wf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvailableTime {

    public void findAvailableTimes(){
        int[][] p1= {{1230, 1330}, {845, 900}, {1300, 1500}};
        int[][] p2 = {{0, 15}, {930, 1200}, {1515, 1546}, {1600, 2400}};
        int[][] p3= {{845, 915}, {1515, 1545}, {1235, 1245}};
        List<int[]> available=new ArrayList<>();
        List<int[]>mergeAll=new ArrayList<>();
        for(int meeting[]:p1){
            mergeAll.add(meeting);
        }
        for(int meeting[]:p2){
            mergeAll.add(meeting);
        }
        for(int meeting[]:p3){
            mergeAll.add(meeting);
        }
        Collections.sort(mergeAll,(a, b)->a[0]-b[0]);
       int prevMeeting[]=mergeAll.get(0);
       if(prevMeeting[0]>0){
           available.add(new int[]{0,prevMeeting[0]});
       }
       for(int i=1;i<mergeAll.size();i++){
           int[]curr=mergeAll.get(i);
           if(prevMeeting[1]<curr[0]){
               available.add(new int[]{prevMeeting[1],curr[0]});
               prevMeeting[0]=curr[0];
               prevMeeting[1]=curr[1];
           }else{
               prevMeeting[0]=curr[0];
               if(prevMeeting[1]<curr[1]){
                  prevMeeting[1]=curr[1];
               }
           }
       }

        for(int[]dts:available){
            System.out.println("[" +dts[0]+","+dts[1]+"]");
        }
        mergeAll=new ArrayList<>();
        available=new ArrayList<>();
        for(int meeting[]:p1){
            mergeAll.add(meeting);
        }

        for(int meeting[]:p3){
            mergeAll.add(meeting);
        }
        Collections.sort(mergeAll,(a,b)->a[0]-b[0]);
        prevMeeting=mergeAll.get(0);
        if(prevMeeting[0]>0){
            available.add(new int[]{0,prevMeeting[0]});
        }
        for(int i=1;i<mergeAll.size();i++){
            int[]curr=mergeAll.get(i);
            if(prevMeeting[1]<curr[0]){
                available.add(new int[]{prevMeeting[1],curr[0]});
                prevMeeting[0]=curr[0];
                prevMeeting[1]=curr[1];
            }else{
                prevMeeting[0]=curr[0];
                if(prevMeeting[1]<curr[1]){
                    prevMeeting[1]=curr[1];
                }
            }
        }
        int[]last=mergeAll.get(mergeAll.size()-1);
        if(last[1]<2400){
            available.add(new int[]{last[1],2400});
        }
        for(int[]dts:available){
            System.out.println("[" +dts[0]+","+dts[1]+"]");
        }
    }
    public static void main(String[] args) {
        AvailableTime availableTime=new AvailableTime();
        availableTime.findAvailableTimes();
    }
}
