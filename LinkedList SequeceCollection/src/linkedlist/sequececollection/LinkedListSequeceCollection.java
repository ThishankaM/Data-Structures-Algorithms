/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist.sequececollection;

/**
 * A simple singly linked list implementation with basic sequence operations.
 * @author Asus
 */
public class LinkedListSequeceCollection {

    /**
     * Node class for the linked list.
     */
    private class Node {
        int data;      // Data stored in the node
        Node next;     // Reference to the next node
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head; // Head node of the list
    private int size;  // Number of elements in the list
    
    /**
     * Constructor to initialize an empty list.
     */
    public LinkedListSequeceCollection() {
        head = null;
        size = 0;
    }
    
    /**
     * Add element at the end of the list.
     * @param element Element to add
     */
    public void add(int element) {
        Node newNode = new Node(element);
        
        if (head == null) {
            head = newNode; // If list is empty, new node becomes head
        } else {
            Node current = head;
            while (current.next != null) { // Traverse to the end
                current = current.next;
            }
            current.next = newNode; // Add new node at the end
        }
        size++;
    }
    
    /**
     * Add element at a specific index.
     * @param index Index to insert at
     * @param element Element to add
     */
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode; // Insert at head
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Traverse to node before index
            }
            Node newNode = new Node(element);
            newNode.next = current.next;
            current.next = newNode; // Insert new node
        }
        size++;
    }
    
    /**
     * Get element at a specific index.
     * @param index Index to retrieve
     * @return Element at index
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Traverse to index
        }
        return current.data;
    }
    
    /**
     * Remove element at a specific index.
     * @param index Index to remove
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            head = head.next; // Remove head
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Traverse to node before index
            }
            current.next = current.next.next; // Remove node
        }
        size--;
    }
    
    /**
     * Get size of the sequence.
     * @return Number of elements
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if sequence is empty.
     * @return True if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Clear the sequence.
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * Print the sequence.
     */
    public void printSequence() {
        Node current = head;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(current.data);
            if (i < size - 1) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
    
    /**
     * Main method to test the LinkedListSequence.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        LinkedListSequeceCollection sequence = new LinkedListSequeceCollection();
        
        // Add elements
        sequence.add(10);
        sequence.add(20);
        sequence.add(30);
        sequence.add(1, 15);
        
        // Print sequence
        System.out.println("Initial sequence:");
        sequence.printSequence();
        
        // Get element at index
        System.out.println("Element at index 2: " + sequence.get(2));
        
        // Remove element
        sequence.remove(1);
        System.out.println("After removing element at index 1:");
        sequence.printSequence();
        
        // Print size
        System.out.println("Size: " + sequence.size());
        
        // Clear sequence
        sequence.clear();
        System.out.println("After clearing, is empty: " + sequence.isEmpty());
    }
}
