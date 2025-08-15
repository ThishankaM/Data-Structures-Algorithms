/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lifo.queue.implementation.using.deque;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;


/**
 *
 * @author Asus
 */
public class LIFOQueueImplementationUsingDeque<T> {

    /**
     * @param args the command line arguments
     */
    private Deque<T> deque;

    // Constructor
    public LIFOQueueImplementationUsingDeque() {
        deque = new ArrayDeque<>();
    }

    // Add element to the top of the queue (push)
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null item");
        }
        deque.push(item);
    }

    // Remove and return the top element (pop)
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return deque.pop();
    }

    // Return the top element without removing it (peek)
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return deque.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Return the size of the queue
    public int size() {
        return deque.size();
    }

    // Clear the queue
    public void clear() {
        deque.clear();
    }

    // Main method for testing
    public static void main(String[] args) {
        LIFOQueueImplementationUsingDeque<String> queue = new LIFOQueueImplementationUsingDeque<>();

        // Test pushing elements
        queue.push("First");
        queue.push("Second");
        queue.push("Third");

        System.out.println("Queue size: " + queue.size()); // Should print 3
        System.out.println("Top element: " + queue.peek()); // Should print "Third"

        // Test popping elements
        System.out.println("Popped: " + queue.pop()); // Should print "Third"
        System.out.println("Popped: " + queue.pop()); // Should print "Second"
        System.out.println("Popped: " + queue.pop()); // Should print "First"

        // Test empty queue
        System.out.println("Is queue empty? " + queue.isEmpty()); // Should print true

        // Test exception handling
        try {
            queue.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Should print "Queue is empty"
        }
    }
    
}
