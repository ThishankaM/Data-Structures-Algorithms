/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author Asus
 */
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    // Node class for the linked list
    class Node {
        int data;      // Value stored in the node
        Node next;     // Reference to the next node
        
        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head; // Head node of the linked list
    
    // Constructor to initialize the linked list
    public LinkedList() {
        head = null;
    }
    
    // Add a node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data); // Create a new node
        
        // If the list is empty, set head to new node
        if (head == null) {
            head = newNode;
            return;
        }
        
        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // Link the new node at the end
        current.next = newNode;
    }
    
    // Add a node at the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head;           // Point new node to current head
        head = newNode;                // Update head to new node
    }
    
    // Delete the first node with the given data
    public void delete(int data) {
        // If the list is empty, do nothing
        if (head == null) {
            return;
        }
        
        // If the head node is to be deleted
        if (head.data == data) {
            head = head.next;
            return;
        }
        
        // Traverse to find the node to delete
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        // If found, unlink the node
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    // Print all elements in the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Main method to test the LinkedList
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Adding elements to the list
        list.append(1);
        list.append(2);
        list.append(3);
        list.prepend(0);
        
        // Print the current list
        System.out.println("Linked List:");
        list.printList();
        
        // Delete element with value 2
        list.delete(2);
        
        // Print the list after deletion
        System.out.println("Linked List after deleting 2:");
        list.printList();
    }
}
