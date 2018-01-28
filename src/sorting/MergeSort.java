package sorting;

/**
 * Created by pavanprakash-g on 1/27/18.
 */
public class MergeSort {
    public void mergeSort(int[] inputArray, int start, int end){
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(inputArray, start, mid);
            mergeSort(inputArray, mid + 1, end);

            merge(inputArray, start, mid, end);
        }
        //return inputArray;
    }

    public void merge(int[] inputArray, int start, int mid, int end){
        int counter = start;
        int[] temp = new int[inputArray.length];
        for(int i = 0 ; i < inputArray.length ; i++){
            temp[i] = inputArray[i];
        }
        int m = mid;
        while (start <= m && end >= mid+1){
            if(temp[start] > temp[mid+1]){
                inputArray[counter] = temp[mid+1];
                mid++;
            }else{
                inputArray[counter] = temp[start];
                start++;
            }
            counter++;
        }

        while (mid+1 <= end){
            inputArray[counter] = temp[mid+1];
            counter++;
            mid++;
        }

        while (start <= m ){
            inputArray[counter] = temp[start];
            counter++;
            start++;
        }
    }



    public static void main(String[] args){
        int arr[] = {4,1,2,3,-1, -2};
        MergeSort m = new MergeSort();
        m.mergeSort(arr, 0, arr.length-1);
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
