/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package liststack;
import java.util.NoSuchElementException;
/**
 *
 * @author Asus
 */
public class ListStack <T> {

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

    private Node top; // Reference to the top node
    private int size; // Size of the stack

    // Constructor
    public ListStack() {
        top = null;
        size = 0;
    }

    // Push: Add element to the top of the stack
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null item");
        }
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop: Remove and return the top element
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    // Peek: Return the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Return the size of the stack
    public int size() {
        return size;
    }

    // Clear the stack
    public void clear() {
        top = null;
        size = 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();

        // Test pushing elements
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack size: " + stack.size()); // Should print 3
        System.out.println("Top element: " + stack.peek()); // Should print "Third"

        // Test popping elements
        System.out.println("Popped: " + stack.pop()); // Should print "Third"
        System.out.println("Popped: " + stack.pop()); // Should print "Second"
        System.out.println("Popped: " + stack.pop()); // Should print "First"

        // Test empty stack
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print true

        // Test exception handling
        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Should print "Stack is empty"
        }
    }
    
}
