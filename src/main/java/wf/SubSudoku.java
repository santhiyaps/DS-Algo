package wf;

import java.util.HashSet;
import java.util.Set;

public class SubSudoku {
    public static void main(String[] args) {
        int n = 3;
        int[][] f = {{1, 3, 2},
                {3, 1, 2},
                {2, 3, 1}};
        System.out.println("Result f : " + checkBlock(f, n));
        int[][] f1 = {{1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}};
        System.out.println("Result f1 : " +checkBlock(f1, n));
        int[][] f2 = {{1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}};
        System.out.println("Result f2 : " + checkBlock(f2, n));
        int[][] f3 = {{3, 2, 3, 2},
                {2, 3, 2, 3},
                {3, 2, 3, 2},
                {2, 3, 2, 3}};
        System.out.println("Result f3 : " + checkBlock(f3, n));
        int[][] f4 = {{1000, -1000, 6},
                {2, 3, 1},
                {3, 1, 2}};
        System.out.println("Result f4 : " + checkBlock(f4, n));
    }

    public static boolean checkBlock(int arr[][],int n){
        Set<Integer>expectedSet=new HashSet<>();
        for(int i=1;i<=n;i++)
            expectedSet.add(i);
        for(int i=0;i<n;i++){
            Set<Integer> rowSet=new HashSet<>();
            for(int j=0;j<n;j++){
                if(arr[i][j]<=0 || rowSet.contains(arr[i][j]))
                    return false;
                rowSet.add(arr[i][j]);
            }
            if(!rowSet.containsAll(expectedSet))
                return false;
        }
        for(int i=0;i<n;i++){
            Set<Integer> columnSet=new HashSet<>();
            for(int j=0;j<n;j++){
                if(arr[j][i]<=0 || columnSet.contains(arr[j][i]))
                    return false;
                columnSet.add(arr[j][i]);
            }
            if(!columnSet.containsAll(expectedSet))
                return false;
        }
        return true;
    }
}
