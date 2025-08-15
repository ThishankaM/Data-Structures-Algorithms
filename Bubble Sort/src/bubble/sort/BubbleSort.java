/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubble.sort;

/**
 *
 * @author Asus
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    // Bubble Sort method for an array of integers
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare adjacent elements and swap if they are in wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test case 1: Random array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.println("Sorted array:");
        printArray(arr1);

        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal array (already sorted):");
        printArray(arr2);
        bubbleSort(arr2);
        System.out.println("Sorted array:");
        printArray(arr2);

        // Test case 3: Array with duplicates
        int[] arr3 = {5, 2, 8, 5, 1, 9, 2, 8};
        System.out.println("\nOriginal array (with duplicates):");
        printArray(arr3);
        bubbleSort(arr3);
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
