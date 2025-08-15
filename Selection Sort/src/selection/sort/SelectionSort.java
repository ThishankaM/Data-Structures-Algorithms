/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selection.sort;

/**
 *
 * @author Asus
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    // Selection Sort method for an array of integers
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted portion
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test case 1: Random array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr1);
        selectionSort(arr1);
        System.out.println("Sorted array:");
        printArray(arr1);

        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal array (already sorted):");
        printArray(arr2);
        selectionSort(arr2);
        System.out.println("Sorted array:");
        printArray(arr2);

        // Test case 3: Array with duplicates
        int[] arr3 = {5, 2, 8, 5, 1, 9, 2, 8};
        System.out.println("\nOriginal array (with duplicates):");
        printArray(arr3);
        selectionSort(arr3);
        System.out.println("Sorted array:");
        printArray(arr3);
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
