/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package priorityqueue;

/**
 *
 * @author Asus
 */
public class PriorityQueue {
    // Array to store heap elements
    private int[] heap;
    // Current number of elements in the heap
    private int size;
    // Default initial capacity of the heap
    private static final int DEFAULT_CAPACITY = 16;
    
    // Constructor: initializes the heap with default capacity
    public PriorityQueue() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }
    
    // Adds an element to the priority queue
    public boolean offer(int value) {
        // Resize the heap array if it's full
        if (size == heap.length) {
            resize();
        }
        
        // Place the new element at the end of the heap
        heap[size] = value;
        size++;
        
        // Restore heap property by sifting the new element up
        siftUp(size - 1);
        return true;
    }
    
    // Removes and returns the element with the highest priority (smallest value)
    public Integer poll() {
        // If the heap is empty, return null
        if (size == 0) {
            return null;
        }
        
        // Store the root element to return later
        int result = heap[0];
        
        // Move the last element to the root position
        heap[0] = heap[size - 1];
        size--;
        
        // Restore heap property by sifting down the new root
        if (size > 0) {
            siftDown(0);
        }
        
        return result;
    }
    
    // Returns the element with the highest priority without removing it
    public Integer peek() {
        // If the heap is empty, return null
        if (size == 0) {
            return null;
        }
        return heap[0];
    }
    
    // Returns the number of elements in the priority queue
    public int size() {
        return size;
    }
    
    // Checks if the priority queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Clears all elements from the priority queue
    public void clear() {
        size = 0;
        heap = new int[DEFAULT_CAPACITY];
    }
    
    // Sifts up the element at the given index to restore heap property
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            // If the current element is not less than its parent, stop
            if (heap[index] >= heap[parent]) {
                break;
            }
            // Swap the current element with its parent
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
        }
    }
    
    // Sifts down the element at the given index to restore heap property
    private void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            
            // Find the smallest among current, left, and right child
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            
            // If the current element is the smallest, stop
            if (smallest == index) {
                break;
            }
            
            // Swap the current element with the smallest child
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            index = smallest;
        }
    }
    
    // Doubles the size of the heap array when it's full
    private void resize() {
        int[] newHeap = new int[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }
    
    // Prints the elements of the priority queue
    public void printQueue() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Main method to test the PriorityQueue implementation
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        
        // Add elements to the priority queue
        pq.offer(5);
        pq.offer(2);
        pq.offer(7);
        pq.offer(1);
        pq.offer(3);
        
        // Print the current state of the queue
        System.out.println("Priority Queue:");
        pq.printQueue();
        
        // Peek at the highest priority element
        System.out.println("Peek: " + pq.peek());
        
        // Remove and print all elements in priority order
        System.out.println("Removing elements:");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
        
        // Print the size of the queue
        System.out.println("Size: " + pq.size());
        
        // Check if the queue is empty
        System.out.println("Is empty: " + pq.isEmpty());
    }
}