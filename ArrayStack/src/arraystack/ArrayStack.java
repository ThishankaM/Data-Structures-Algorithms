/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraystack;
import java.util.NoSuchElementException;

/**
 *
 * @author Asus
 */
public class ArrayStack<T> {

    /**
     * @param args the command line arguments
     */
    private T[] array; // Array to store stack elements
    private int top; // Index of the top element
    private int capacity; // Current capacity of the array
    private static final int DEFAULT_CAPACITY = 10; // Default initial capacity

    // Constructor
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1; // Stack is empty
        capacity = DEFAULT_CAPACITY;
    }

    // Push: Add element to the top of the stack
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null item");
        }
        // Check if array is full and resize if necessary
        if (top + 1 == capacity) {
            resize();
        }
        array[++top] = item;
    }

    // Pop: Remove and return the top element
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = array[top];
        array[top--] = null; // Help garbage collection
        return item;
    }

    // Peek: Return the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return array[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Return the size of the stack
    public int size() {
        return top + 1;
    }

    // Clear the stack
    @SuppressWarnings("unchecked")
    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
        capacity = DEFAULT_CAPACITY;
    }

    // Helper method to resize the array when full
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2; // Double the capacity
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();

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
