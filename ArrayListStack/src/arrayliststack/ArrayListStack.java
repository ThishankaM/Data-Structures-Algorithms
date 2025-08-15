/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrayliststack;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Asus
 */
public class ArrayListStack <T> {

    /**
     * @param args the command line arguments
     */
    private ArrayList<T> list; // ArrayList to store stack elements

    // Constructor
    public ArrayListStack() {
        list = new ArrayList<>();
    }

    // Push: Add element to the top of the stack
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null item");
        }
        list.add(item);
    }

    // Pop: Remove and return the top element
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    // Peek: Return the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Return the size of the stack
    public int size() {
        return list.size();
    }

    // Clear the stack
    public void clear() {
        list.clear();
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayListStack<String> stack = new ArrayListStack<>();

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
