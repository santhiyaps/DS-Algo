package pattern.slidingWindow;

import java.util.HashMap;

public class MinWindowSubString {
    /*Given two strings s and t, return the minimum window in s which will contain all the characters in t.
    If there is no such window in s that covers all characters in t, return the empty string "".*/
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int start=0,end=0;
        int min=Integer.MAX_VALUE;
        String minString="";
        HashMap<Character,Integer> tMap=new HashMap<Character,Integer>();
        for(char c:t.toCharArray()){
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> sMap=new HashMap<Character,Integer>();
        int tSize=tMap.size();
        int foundt=0;
        while(end<s.length()){
            char c=s.charAt(end);
            if(tMap.containsKey(c)){
                sMap.put(c,sMap.getOrDefault(c,0)+1);
                if(tMap.get(c).intValue() ==sMap.get(c).intValue() ){
                    foundt++;
                }
            }
            while(foundt==tMap.size()&& tMap.size()==sMap.size() && start <s.length()){
                int findLength=end-start+1;
                if(findLength<min){
                    min=findLength;
                    minString=s.substring(start,end+1);
                }
                char firstChar=s.charAt(start);
                if(sMap.containsKey(firstChar)){
                    sMap.put(firstChar,sMap.get(firstChar)-1);
                    if(sMap.get(firstChar).intValue() <tMap.get(firstChar).intValue() )
                        foundt--;
                    if(sMap.get(firstChar).intValue() ==0)
                        sMap.remove(firstChar);
                }
                start++;
            }
            end++;
        }
        return minString;
    }

    public static void main(String[] args) {
        MinWindowSubString minWindowSubString=new MinWindowSubString();
        System.out.println(smallestSubstringContaining("abzacdwejxjftghiwjtklmnopqrstuvwxyz" ,
                "aajjttwwxxzz"));
    }

    public static String smallestSubstringContaining(String bigString, String smallString) {
        HashMap<Character,Integer>smallMap=new HashMap<Character,Integer>();
        HashMap<Character,Integer>bigMap=new HashMap<Character,Integer>();
        int start=0,end=0,found=0;
        int min=Integer.MAX_VALUE;
        String minString="";
        for(char c:smallString.toCharArray()){
            smallMap.put(c,smallMap.getOrDefault(c,0)+1);
        }
        while(end<bigString.length()){
            char c=bigString.charAt(end);
            if(smallMap.containsKey(c)){
                bigMap.put(c,bigMap.getOrDefault(c,0)+1);
                if(bigMap.get(c).intValue()==smallMap.get(c).intValue())
                        found++;
                while(found==smallMap.size() && start<bigString.length()){
                    if(min>end-start+1){
                        min=end-start+1;
                        minString=bigString.substring(start,end+1);
                    }
                    char startChar=bigString.charAt(start);
                    if(bigMap.containsKey(startChar)){
                        bigMap.put(startChar,bigMap.getOrDefault(startChar,0)-1);
                        if(bigMap.get(startChar).intValue()<smallMap.get(startChar).intValue())
                            found--;
                        if(bigMap.get(startChar).intValue()==0){
                            bigMap.remove(startChar);
                        }
                    }
                    start++;
                }

            }
            end++;
        }
        return minString;
    }
}
