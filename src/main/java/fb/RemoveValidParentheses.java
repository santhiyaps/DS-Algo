package fb;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class RemoveValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        Set<Integer>indexes=new HashSet<>();
        Deque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
               stack.add(i);
            }else if(s.charAt(i)==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    indexes.add(i);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            indexes.add(stack.pop());
        }
        for(int i=0;i<s.length();i++){
            if(!indexes.contains(i))
              sb.append(s.charAt(i));
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
