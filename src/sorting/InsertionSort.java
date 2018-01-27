package sorting;

/**
 * Created by pavanprakash-g on 1/27/18.
 */
public class InsertionSort {

    private static void sort(int[] inputArray){
        int temp, r=0;
        for(int i = 1; i<inputArray.length; i++){
            temp = inputArray[i];
            r =i-1;
            while (r>=0 &&temp<inputArray[r]) {
                inputArray[r+1] = inputArray[r];
                r--;
            }
            inputArray[r+1] = temp;
        }

        for(int i = 0 ; i < inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }

    public static void main(String[] args){
        sort(new int[]{1,4,2,3,-1});
    }
}
