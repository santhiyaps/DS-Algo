package pattern.slidingWindow;

import java.util.HashMap;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int start=0,end=0;
        int found=0;
        HashMap<Character,Integer> charMap=new HashMap<Character,Integer>();
        for(char c:pattern.toCharArray()){
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }
        while(end<str.length()){
            char c=str.charAt(end);
            if(charMap.containsKey(c)){
                charMap.put(c,charMap.get(c)-1);
                if(charMap.get(c)==0)
                    found++;
            }

            if(charMap.size()==found)
                return true;
            if(end>= pattern.length()-1){
                char startChar=str.charAt(start);
                if(charMap.containsKey(startChar)){
                    if(charMap.get(startChar)==0)
                        found--;
                    charMap.put(startChar,charMap.get(startChar)+1);
                }
                start++;

            }

            end++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("aaacb","abc"));
    }
}
