package wf;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[]charArray=new int[128];
        for(char c:s.toCharArray()){
            charArray[c]++;
        }
        int result=0;
        for(int i=0;i<128;i++){
            int count=charArray[i];
            result+=count/2*2;
            if(result%2==0 && count%2==1 )
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome= new LongestPalindrome();
        longestPalindrome.longestPalindrome("abccccdd");
    }
}
