package pattern.twopointer;

public class SortedArraySquares {
    /*  Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.*/

    public static int[] makeSquares(int[] arr) {
        int left = 0, right = arr.length - 1;
        int squareArr[] = new int[arr.length];
        int len = arr.length - 1;
        while (left < right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squareArr[len] = leftSquare;
                len--;
                left++;
            } else {
                squareArr[len] = rightSquare;
                len--;
                right--;
            }
        }
        return squareArr;
    }

    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}

