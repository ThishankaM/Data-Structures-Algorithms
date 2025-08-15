/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackqueue;
import java.util.Stack;
import java.util.NoSuchElementException;

/**
 *
 * @author Asus
 */
public class StackQueue<T> {

    /**
     * @param args the command line arguments
     */
    private Stack<T> stackEnqueue; // Stack for adding elements
    private Stack<T> stackDequeue; // Stack for removing elements

    // Constructor
    public StackQueue() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    // Enqueue: Add element to the rear of the queue
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue null item");
        }
        stackEnqueue.push(item);
    }

    // Dequeue: Remove and return the front element
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // If dequeue stack is empty, transfer elements from enqueue stack
        if (stackDequeue.isEmpty()) {
            transferElements();
        }
        return stackDequeue.pop();
    }

    // Peek: Return the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // If dequeue stack is empty, transfer elements from enqueue stack
        if (stackDequeue.isEmpty()) {
            transferElements();
        }
        return stackDequeue.peek();
    }

    // Helper method to transfer elements from enqueue stack to dequeue stack
    private void transferElements() {
        while (!stackEnqueue.isEmpty()) {
            stackDequeue.push(stackEnqueue.pop());
        }
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    // Return the size of the queue
    public int size() {
        return stackEnqueue.size() + stackDequeue.size();
    }

    // Clear the queue
    public void clear() {
        stackEnqueue.clear();
        stackDequeue.clear();
    }

    // Main method for testing
    public static void main(String[] args) {
        StackQueue<String> queue = new StackQueue<>();

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
