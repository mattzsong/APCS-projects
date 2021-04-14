import java.util.*;

public class QuickSort {
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
        System.out.print("Original: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("Sorted high to low: ");
        quickSort(nums, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static class InvalidOperationException extends Exception {
        private static final long serialVersionUID = 1L;

        public InvalidOperationException(String string) {
            super(string);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low+1;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] >= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i-1, low);
        return (i-1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
