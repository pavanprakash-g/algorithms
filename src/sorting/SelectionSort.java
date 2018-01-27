package sorting;

/**
 * Created by pavanprakash-g on 1/27/18.
 */
public class SelectionSort {

    static void sort(int[] inputArray){
        int p = 0;
        int index = 0, temp = 0;
        int r = inputArray.length;
        for (p = 0; p < r; p++){
            index = p;
            for(int i = p; i < r ; i++){
                if(inputArray[index] > inputArray[i]){
                    index = i;
                }
            }
            temp = inputArray[index];
            inputArray[index] = inputArray[p];
            inputArray[p] = temp;
        }
        for(int i = 0 ;i<inputArray.length;i++){
            System.out.println(inputArray[i]);
        }
    }

    public static void main(String[] args){
        SelectionSort.sort(new int[]{1,4,2,3,-1});
    }
}
