package sorting;

/**
 * Created by pavanprakash-g on 1/27/18.
 */
public class MergeSort {
    public static int[] mergeSort(int[] inputArray, int start, int end){
        if(start < end) {
            int mid = (start + end) / 2;
            int[] left = mergeSort(inputArray, start, mid);
            int[] right = mergeSort(inputArray, mid + 1, end);

            return merge(left, right);
        }else {
            return new int[]{inputArray[start]};
        }

    }

    private static int[] merge(int[] left, int[] right){
        int lp = 0;
        int rp = 0;
        int inputCounter = 0;
        int[] result = new int[left.length + right.length];
        while(lp < left.length && rp < right.length){
            if(left[lp] < right[rp]){
                result[inputCounter] = left[lp];
                lp++;
            }else {
                result[inputCounter] = right[rp];
                rp++;
            }
            inputCounter++;
        }

        while (lp < left.length){
            result[inputCounter] = left[lp];
            inputCounter++;
            lp++;
        }

        while (rp < right.length){
            result[inputCounter] = right[rp];
            inputCounter++;
            rp++;
        }

        return result;

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
//        MergeSort m = new MergeSort();
//        m.mergeSort(arr, 0, arr.length-1);
        int[] result = MergeSort.mergeSort(arr, 0, arr.length-1);
        for(int i = 0 ; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

}
