package wf;

public class LongestSpendingPattern {
    private static void lcs() {
        String[] useridList={"user1", "user2", "user3", "user4"};
        String[][] categoryList={{"fashion","restaurant","grocery","utility"},
                {"fuel","fashion","restaurant","grocery"},
                {"fuel","utility","restaurant","grocery"},
                {"internet","transportation","water","grocery"}};
        int dp[][]=new int[categoryList[0].length+1][categoryList[1].length+1];
        int max=0,end=0;
       for(int i=categoryList[0].length-1;i>=0;i--){
           for(int j=categoryList[1].length-1;j>=0;j--){
               if(categoryList[0][i].equals(categoryList[1][j])){
                   dp[i][j]=1+dp[i+1][j+1];
                   if(max<dp[i][j]){
                       max=dp[i][j];
                       end=j;
                       break;
                   }
               }
           }
       }
       String result="";
        System.out.println(end);
       for(int i=end;i<end+max;i++){
           result+=categoryList[1][i];
       }
        System.out.println(result);
    }

    public static void main(String[] args) {
        lcs();
    }
}
