package wf;

import java.util.ArrayList;
import java.util.List;

public class FindContigousSubArray {
    public static List<String> findContiguousHistory(String[] user1, String[] user2) {
      int dp[][]=new int[user1.length+1][user2.length+1];
      int endIndex=0;
      int max=0;
      for(int i=user1.length-1;i>=0;i--){
          for(int j=user2.length-1;j>=0;j--){
              if(user1[i].equals(user2[j])){
                  dp[i][j]=1+dp[i+1][j+1];
                  if(max<dp[i][j]){
                      max=dp[i][j];
                      endIndex=j;
                  }
                  break;
              }
          }
      }
      List<String>result=new ArrayList<>();
      for(int j=endIndex;j<endIndex+max;j++){
          result.add(user2[j]);

      }
      return result;
    }

    public static void main(String[] args) {
       String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow","/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue","/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange","/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red","/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5= {"a"};
        String[] user6 = {"/pink","/orange","/six","/plum","/seven","/tan","/red","/amber"};
        System.out.println(findContiguousHistory(user0,user1));
    }

}
