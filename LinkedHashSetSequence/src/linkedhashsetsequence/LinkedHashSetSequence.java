/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedhashsetsequence;

/**
 * Custom LinkedHashSetSequence implementation.
 * Maintains insertion order and uniqueness using a doubly-linked list and hash table.
 *
 * @author Asus
 */
public class LinkedHashSetSequence {
    // Node class for doubly-linked list and hash table
    private class Node {
        int data;      // Value stored in node
        Node next;     // For hash table chaining
        Node prev;     // Previous node in order
        Node succ;     // Next node in order
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            this.succ = null;
        }
    }
    
    private Node[] buckets; // Hash table buckets
    private Node head;      // Head of doubly-linked list
    private Node tail;      // Tail of doubly-linked list
    private int size;       // Number of elements
    private static final int INITIAL_CAPACITY = 16; // Initial hash table size
    private static final double LOAD_FACTOR = 0.75; // Load factor for resizing
    
    // Constructor
    public LinkedHashSetSequence() {
        buckets = new Node[INITIAL_CAPACITY];
        head = null;
        tail = null;
        size = 0;
    }
    
    // Hash function for integer values
    private int hash(int value) {
        return Math.abs(value % buckets.length);
    }
    
    // Add element to the set (at the end)
    public boolean add(int value) {
        // Resize if load factor exceeded
        if ((double) (size + 1) / buckets.length >= LOAD_FACTOR) {
            resize();
        }
        
        int index = hash(value);
        
        // Check for duplicates in hash table
        Node current = buckets[index];
        while (current != null) {
            if (current.data == value) {
                return false; // Value already exists
            }
            current = current.next;
        }
        
        // Create new node
        Node newNode = new Node(value);
        
        // Add to hash table (chaining)
        newNode.next = buckets[index];
        buckets[index] = newNode;
        
        // Add to doubly-linked list (maintain order)
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.succ = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        size++;
        return true;
    }
    
    // Add element at specific index in the order
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        // Check for duplicate
        if (contains(value)) {
            return; // Don't add duplicates
        }
        
        // Resize if load factor exceeded
        if ((double) (size + 1) / buckets.length >= LOAD_FACTOR) {
            resize();
        }
        
        Node newNode = new Node(value);
        int hashIndex = hash(value);
        
        // Add to hash table (chaining)
        newNode.next = buckets[hashIndex];
        buckets[hashIndex] = newNode;
        
        // Add to doubly-linked list at specified index
        if (index == 0) { // Insert at head
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.succ = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (index == size) { // Insert at tail
            tail.succ = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else { // Insert in the middle
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.succ;
            }
            newNode.succ = current;
            newNode.prev = current.prev;
            current.prev.succ = newNode;
            current.prev = newNode;
        }
        
        size++;
    }
    
    // Get element at specific index in the order
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.succ;
        }
        return current.data;
    }
    
    // Remove element by value
    public boolean remove(int value) {
        int index = hash(value);
        
        Node current = buckets[index];
        Node prev = null;
        
        // Find node in hash table
        while (current != null) {
            if (current.data == value) {
                // Remove from hash table
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                
                // Remove from doubly-linked list
                if (current.prev != null) {
                    current.prev.succ = current.succ;
                } else {
                    head = current.succ;
                }
                
                if (current.succ != null) {
                    current.succ.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }
    
    // Check if set contains value
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
    
    // Get size of the set
    public int size() {
        return size;
    }
    
    // Check if set is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Clear the set
    public void clear() {
        buckets = new Node[INITIAL_CAPACITY];
        head = null;
        tail = null;
        size = 0;
    }
    
    // Resize the hash table and rehash all elements
    private void resize() {
        Node[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2];
        
        // Rehash all elements from the linked list
        Node current = head;
        while (current != null) {
            int index = hash(current.data);
            Node newNode = new Node(current.data);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            current = current.succ;
        }
    }
    
    // Print the set in insertion order
    public void printSet() {
        System.out.print("[");
        Node current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.data);
            if (i < size - 1) {
                System.out.print(", ");
            }
            current = current.succ;
        }
        System.out.println("]");
    }
    
    // Main method to test the LinkedHashSetSequence
    public static void main(String[] args) {
        LinkedHashSetSequence set = new LinkedHashSetSequence();
        
        // Add elements
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // Duplicate, should not be added
        
        // Print set
        System.out.println("Initial set:");
        set.printSet();
        
        // Add at index
        set.add(1, 15);
        System.out.println("After adding 15 at index 1:");
        set.printSet();
        
        // Get element at index
        System.out.println("Element at index 2: " + set.get(2));
        
        // Check contains
        System.out.println("Contains 15: " + set.contains(15));
        System.out.println("Contains 25: " + set.contains(25));
        
        // Remove element
        set.remove(20);
        System.out.println("After removing 20:");
        set.printSet();
        
        // Print size
        System.out.println("Size: " + set.size());
        
        // Clear set
        set.clear();
        System.out.println("After clearing, is empty: " + set.isEmpty());
    }
}