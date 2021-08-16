package fb;

public class AlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        int [] arr=new int [26];
        for(int i=0;i<order.length();i++){
            arr[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            if(!order(words[i-1],words[i],arr)) return false;
        }
        return true;
    }

    private static boolean order(String a,String b,int []arr){
        for(int i=0;i<a.length() && i<b.length();i++){
            if(a.charAt(i)== b.charAt(i))continue;
            else{
               return arr[a.charAt(i)-'a']< arr[b.charAt(i)-'a'];
            }
        }
        if(a.length()>b.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"kuvp","q"},
        "ngxlkthsjuoqcpavbfdermiywz"));
    }
}
