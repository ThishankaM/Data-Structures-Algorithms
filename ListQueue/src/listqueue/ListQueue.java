/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listqueue;
import java.util.NoSuchElementException;
/**
 *
 * @author Asus
 */
public class ListQueue <T> {

    /**
     * @param args the command line arguments
     */
    // Node class for the linked list
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front; // Reference to the front node
    private Node rear; // Reference to the rear node
    private int size; // Size of the queue

    // Constructor
    public ListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue: Add element to the rear of the queue
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue null item");
        }
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue: Remove and return the front element
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null; // Ensure rear is null when queue becomes empty
        }
        return item;
    }

    // Peek: Return the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the size of the queue
    public int size() {
        return size;
    }

    // Clear the queue
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        ListQueue<String> queue = new ListQueue<>();

        // Test enqueueing elements
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        System.out.println("Queue size: " + queue.size()); // Should print 3
        System.out.println("Front element: " + queue.peek()); // Should print "First"

        // Test dequeuing elements
        System.out.println("Dequeued: " + queue.dequeue()); // Should print "First"
        System.out.println("Dequeued: " + queue.dequeue()); // Should print "Second"
        System.out.println("Dequeued: " + queue.dequeue()); // Should print "Third"

        // Test empty queue
        System.out.println("Is queue empty? " + queue.isEmpty()); // Should print true

        // Test exception handling
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Should print "Queue is empty"
        }
    }
    
}
