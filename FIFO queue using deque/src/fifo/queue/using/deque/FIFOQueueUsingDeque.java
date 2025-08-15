/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fifo.queue.using.deque;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;


/**
 *
 * @author Asus
 */
public class FIFOQueueUsingDeque<T> {

    /**
     * @param args the command line arguments
     */
    private Deque<T> deque;

    // Constructor
    public FIFOQueueUsingDeque() {
        deque = new ArrayDeque<>();
    }

    // Enqueue: Add element to the rear of the queue
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue null item");
        }
        deque.addLast(item);
    }

    // Dequeue: Remove and return the front element
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return deque.removeFirst();
    }

    // Peek: Return the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return deque.getFirst();
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
        FIFOQueueUsingDeque<String> queue = new FIFOQueueUsingDeque<>();

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
