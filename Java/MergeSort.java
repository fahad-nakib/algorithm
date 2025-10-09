public class MergeSort {
    public void merge(int[] arr, int left,int mid, int right){
        int leftArrayLength = mid-left+1;
        int rightArrayLength = right-mid;

        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        for (int i=0; i<leftArrayLength; i++){
            leftArray[i]= arr[left+i];
        }
        for (int j=0; j<rightArrayLength; j++){
            rightArray[j] = arr[mid+1+j];
        }

        int i=0, j=0, k=left;

        while (i < leftArrayLength && j < rightArrayLength){
            if ( leftArray[i] < rightArray[j] ){
                arr[k] = leftArray[i];
                i++;
            }else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArrayLength){
            arr[k] = leftArray[i];
            i++; k++;
        }
        while (j < rightArrayLength){
            arr[k] = rightArray[j];
            j++; k++;
        }
    }
    public void callMergeSort(int[] arr, int left, int right){
        if (left<right){
            int mid = left+ (right-left)/2;

            callMergeSort(arr,left,mid);
            callMergeSort(arr, mid+1, right);
            
            merge(arr,left,mid,right);
        }
    }
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {38, 27, 43, 10};

        ms.callMergeSort(arr,0,arr.length-1);
        for(int value : arr){
            System.out.print(value+" ");
        }

    }
}
