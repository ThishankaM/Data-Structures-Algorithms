/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package insertion.sort;

/**
 *
 * @author Asus
 */
public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    // Insertion Sort method for an array of integers
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to be inserted
            int j = i - 1;   // Index of the last element in sorted portion
            
            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // Place key in its correct position
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test case 1: Random array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr1);
        insertionSort(arr1);
        System.out.println("Sorted array:");
        printArray(arr1);

        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal array (already sorted):");
        printArray(arr2);
        insertionSort(arr2);
        System.out.println("Sorted array:");
        printArray(arr2);

        // Test case 3: Array with duplicates
        int[] arr3 = {5, 2, 8, 5, 1, 9, 2, 8};
        System.out.println("\nOriginal array (with duplicates):");
        printArray(arr3);
        insertionSort(arr3);
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
