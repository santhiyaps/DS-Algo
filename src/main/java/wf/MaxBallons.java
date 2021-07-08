package wf;

public class MaxBallons {
    public int maxBallons(String text){
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        int min = 0;
        for (char c: text.toCharArray()) {
            if (c == 'b') b++;
            if (c == 'a') a++;
            if (c == 'l') l++;
            if (c == 'o') o++;
            if (c == 'n') n++;
        }
        min = Math.min(Math.min(b, Math.min(a, l/2)) , Math.min(o/2, n));
        return min;
    }
}
