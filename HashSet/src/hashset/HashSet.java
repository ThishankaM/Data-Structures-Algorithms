/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hashset;

/**
 * Simple implementation of a HashSet for integers using separate chaining.
 * @author Asus
 */
public class HashSet {

    /**
     * Node class for linked list (used for chaining in buckets)
     */
    private class Node {
        int data;      // Value stored in the node
        Node next;     // Reference to the next node
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node[] buckets;                  // Array of buckets for hash table
    private int size;                        // Number of elements in the set
    private static final int INITIAL_CAPACITY = 16; // Initial number of buckets
    private static final double LOAD_FACTOR = 0.75; // Load factor for resizing
    
    // Constructor: initializes buckets and size
    public HashSet() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }
    
    // Hash function: computes bucket index for a value
    private int hash(int value) {
        return Math.abs(value % buckets.length);
    }
    
    // Adds an element to the set; returns true if added, false if already present
    public boolean add(int value) {
        // Resize if load factor exceeded
        if ((double) (size + 1) / buckets.length >= LOAD_FACTOR) {
            resize();
        }
        
        int index = hash(value);
        
        // If bucket is empty, add directly
        if (buckets[index] == null) {
            buckets[index] = new Node(value);
            size++;
            return true;
        }
        
        // Traverse linked list to check for duplicates
        Node current = buckets[index];
        Node prev = null;
        
        while (current != null) {
            if (current.data == value) {
                return false; // Value already exists
            }
            prev = current;
            current = current.next;
        }
        
        // Add new node at the end of the list
        prev.next = new Node(value);
        size++;
        return true;
    }
    
    // Removes an element from the set; returns true if removed, false if not found
    public boolean remove(int value) {
        int index = hash(value);
        
        Node current = buckets[index];
        Node prev = null;
        
        while (current != null) {
            if (current.data == value) {
                // Remove node from list
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }
    
    // Checks if the set contains a value
    public boolean contains(int value) {
        int index = hash(value);
        
        Node current = buckets[index];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Returns the number of elements in the set
    public int size() {
        return size;
    }
    
    // Checks if the set is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Clears the set, removing all elements
    public void clear() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }
    
    // Resizes the hash table when load factor is exceeded
    private void resize() {
        Node[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2];
        size = 0;
        
        // Rehash all elements into new buckets
        for (Node bucket : oldBuckets) {
            Node current = bucket;
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }
    
    // Prints the set elements in curly braces
    public void printSet() {
        System.out.print("{");
        boolean first = true;
        for (Node bucket : buckets) {
            Node current = bucket;
            while (current != null) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(current.data);
                first = false;
                current = current.next;
            }
        }
        System.out.println("}");
    }
    
    // Main method to test the HashSet implementation
    public static void main(String[] args) {
        HashSet set = new HashSet();
        
        // Add elements
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2); // Duplicate, should not be added
        
        // Print set
        System.out.println("Initial set:");
        set.printSet();
        
        // Check contains
        System.out.println("Contains 2: " + set.contains(2));
        System.out.println("Contains 4: " + set.contains(4));
        
        // Remove element
        set.remove(2);
        System.out.println("After removing 2:");
        set.printSet();
        
        // Print size
        System.out.println("Size: " + set.size());
        
        // Clear set
        set.clear();
        System.out.println("After clearing, is empty: " + set.isEmpty());
    }
}
