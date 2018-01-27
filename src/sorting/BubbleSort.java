package sorting;

/**
 * Created by pavanprakash-g on 1/27/18.
 */
public class BubbleSort {

    private static void sort(int[] inputArray){
        int size = inputArray.length-1;
        int i = 0, j = 0, temp = 0;
        while (j <= size && size > 0){
            j = i+1;
            if(inputArray[i] > inputArray[j]){
                //Following can be used only when the input numbers are non negative.
                /*inputArray[i] = inputArray[i] + inputArray[j];
                inputArray[j] = inputArray[i] - inputArray[j];
                inputArray[i] = inputArray[i] - inputArray[j];*/
                temp = inputArray[j];
                inputArray[j] = inputArray[i];
                inputArray[i] = temp;
            }
            i++;
            if(j==size){
                size--;
                i = 0;
                j = 0;
            }
        }

        for(i = 0 ; i < inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }

    public static void main(String[] args){
        sort(new int[]{1,4,2,3,-1});
    }

}