package pattern.slidingWindow;

import java.util.HashMap;

public class CharacterReplacement {
   /* Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
    find the length of the longest substring having the same letters after replacement.*/
   public static int findLength(String str, int k) {
       int start=0,end=0;
       int max=0;
       int maxRepeatCount=0;
       HashMap<Character,Integer> charMap=new HashMap();
       while(end<str.length()){
           char c=str.charAt(end);
           charMap.put(c,charMap.getOrDefault(c,0)+1);
           maxRepeatCount=Math.max(maxRepeatCount,charMap.get(c).intValue());
           while(end-start+1-maxRepeatCount>k){
               char startChar=str.charAt(start);
               charMap.put(startChar,charMap.get(startChar)-1);
               start++;
           }
           max=Math.max(max,end-start+1);
           end++;
       }
       return max;
   }

    public static void main(String[] args) {
        System.out.println(findLength("abbcb",1));
    }
}
