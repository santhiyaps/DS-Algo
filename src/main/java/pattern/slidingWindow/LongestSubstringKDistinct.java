package pattern.slidingWindow;

import java.util.HashMap;

public class LongestSubstringKDistinct {
   /* Given a string, find the length of the longest substring in it with no more than K distinct characters.*/
   public static int findLength(String str, int k) {
       int start=0,end=0;
       int max=Integer.MIN_VALUE;
       HashMap<Character,Integer> charMap=new HashMap<Character,Integer>();
       while(end<str.length()){
           char c=str.charAt(end);
           charMap.put(c,charMap.getOrDefault(c,0)+1);
           while(charMap.size()>k){
               char outerChar=str.charAt(start);
               charMap.put(outerChar,charMap.getOrDefault(outerChar,0)-1);
               if(charMap.get(outerChar)==0)
                   charMap.remove(outerChar);
               start++;
           }
           max=Math.max(max,end-start+1);
           end++;
       }
       return max;
   }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
