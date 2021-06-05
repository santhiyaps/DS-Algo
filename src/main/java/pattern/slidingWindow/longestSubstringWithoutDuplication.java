package pattern.slidingWindow;

import java.util.HashSet;

public class longestSubstringWithoutDuplication {
    public static String longestSubstringWithoutDuplication(String str) {
        HashSet<Character> charSet=new HashSet<Character>();
        int start=0,end=0,max=0;
        String maxString="";
        while(end<str.length()){
            if(charSet.contains(str.charAt(end))){
                charSet.remove(str.charAt(start));
                start++;
            }else{
                charSet.add(str.charAt(end));
                end++;
                if(max<end-start){
                    maxString=str.substring(start,end);
                    max=end-start;
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
    }
}
