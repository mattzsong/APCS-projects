import java.util.*;

public class MergeSort {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the length of the array of ints.");
        while (true) {
            try {
                n = sc.nextInt();
                if (n < 1 || n > 10)
                    throw new InvalidOperationException("Length of array is no greater than 10.");
                break;
            } catch (InvalidOperationException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println("Integer must be inputted.");
            }
        }

        int[] nums = new int[n];
        System.out.println("Enter the integers separated by a space. Ex. 1 2 3 4 5");
        while (true) {
            try {
                for (int i = 0; i < n; i++) {
                    nums[i] = sc.nextInt();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Integer must be inputted.");
            }
        }
        sc.close();
        sort(nums, 0, nums.length-1);
        System.out.print("Sorted array: ");
        for(int i = 0 ; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
        
        System.out.println("Enter an integer to search for: ");
        int num = sc.nextInt();
        if(binarySearch(nums, 0, nums.length-1, num) == -1) System.out.println("No number found.");
        else System.out.println("Number found at index " + binarySearch(nums, 0, nums.length-1, num));
    }

    public static void sort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = (left + right)/2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);

        merge(arr, left, mid ,right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int leftIndex = left;
        int rightIndex = mid+1;
        int[] newSub = new int[right-left+1];
        while(leftIndex <= mid && rightIndex <= right){
            if(arr[leftIndex] < arr[rightIndex]){
                newSub[leftIndex-left+rightIndex-mid-1] = arr[leftIndex];
                leftIndex++;
            }
            else{
                newSub[leftIndex-left+rightIndex-mid-1] = arr[rightIndex];
                rightIndex++;
            }
        }
        for(int i = leftIndex; i <= mid; i++){
            newSub[i-left+rightIndex-mid-1] = arr[i];
        }
        for(int i = rightIndex; i <= right; i++){
            newSub[leftIndex-left+i-mid-1] = arr[i];
        }

        for(int i = left; i <= right; i++){
            arr[i] = newSub[i-left];
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int target){
        if(left > right) return -1;
        int mid = (left + right) /2 ;
        if(arr[mid] == target) return mid;
        else if(target < arr[mid]) return binarySearch(arr, left, mid-1, target);
        else                       return binarySearch(arr, mid+1, right, target);
    }

    public static class InvalidOperationException extends Exception {
        private static final long serialVersionUID = 1L;

        public InvalidOperationException(String string) {
            super(string);
        }
    }
}
