package sorting;

/**
 * Created by pavanprakash-g on 1/27/18.
 */
public class QuickSort {
    public void quickSort(int[] inputArray, int start, int end){
        if(start < end) {
            int partition = partition(inputArray, start, end);
            quickSort(inputArray, start, partition-1);
            quickSort(inputArray, partition + 1, end);
        }
    }


    public int partition (int arr[], int low, int high){
        int pivot = arr[high];
        int i = low;
        int temp;
        for(int j = low; j <= high- 1; j++){
            if (arr[j] <= pivot){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args){
        int arr[] = {4,1,2,3,-1, -2};
        QuickSort m = new QuickSort();
        m.quickSort(arr, 0, arr.length-1);
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
