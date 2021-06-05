package ds.dynamicPgming;

public class MaxSubsetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array==null || array.length==0){
            return 0;
        }else if(array.length==1){
            return array[0];
        }

        int n[]=array.clone();
        n[1]=Math.max(array[0],array[1]);
        for(int i=2;i<array.length;i++){
            n[i]=Math.max(n[i-1],n[i-2]+array[i]);
        }
        return n[array.length-1];
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135}));
    }
}
