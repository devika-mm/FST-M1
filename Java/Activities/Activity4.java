package activities;
import java.util.Arrays;

class Activity4 {
    static void ascendingSort(int arr[]) {

        for (int i = 1; i <= arr.length-1; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        int[] arr = { 2, 1, 9, 0, 3 };
        ascendingSort(arr);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(arr));
    }
}