public class BinarySearch {
    // Binary Search Using  RECURSIVE  Technique
    public static int search(int[] arr, int low, int high, int target){
        if (high >= low){
            int mid = low + (high-low)/2;
            if (arr[mid] == target){
                return mid;
            } else if (target>arr[mid]) {
                return search(arr,mid+1,high,target);
            } else if (target<arr[mid]) {
                return search(arr,low,mid-1,target);
            }
        }
        return -1;
    }

    //Binary Search Using  ITERATIVE  Technique

    public static int search2(int[] arr, int low, int high, int target) {
        while (high >= low){

            int mid = low + (high-low)/2;

            if (arr[mid] == target){
                return mid;
            } else if (target>arr[mid]) {
                low = mid+1;
            } else if (target<arr[mid]) {
                high = mid-1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,6,8,9,13,16,17,21,25,29,33,38,41,45,49};

        //int target = 29;
        int target = 42;
        
        int low = 0;
        int high = arr.length-1;

        //Call Recursive method
        //int result = search(arr,low, high,target);

        //Call Iterative method
        int result = search2(arr,low, high,target);
        if (result == -1){
            System.out.println("Element not found ! ");
        }else {
            System.out.println("Element present at index : "+ result);
        }
    }
}
