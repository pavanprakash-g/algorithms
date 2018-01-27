package sorting;

/**
 * Created by pavanprakash-g on 1/27/18.
 */
public class RecursiveBubbleSort {

    private static int[] sort(int[] inputArray, int size){
        if(size == 0){
            return inputArray;
        }
        for(int i = 0 ; i < size-1 ; i++){
            if(inputArray[i] > inputArray[i+1]){
                int temp = inputArray[i+1];
                inputArray[i+1] = inputArray[i];
                inputArray[i] = temp;
            }
        }
        inputArray = sort(inputArray, --size);
        return inputArray;
    }

    public static void main(String[] args){
        int[] inputArray = RecursiveBubbleSort.sort(new int[]{1,4,2,3,-1}, 5);
        for(int i = 0 ;i<inputArray.length;i++){
            System.out.println(inputArray[i]);
        }
    }
}
