package wf;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>visited=new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char curr=board[i][j];
                if(curr!='.'){
                    if(!visited.add(curr+" seen in row"+i)||
                            !visited.add (curr+" seen in column"+j) ||
                            !visited.add(curr+" seen in row and column"+i/3 +"-"+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
