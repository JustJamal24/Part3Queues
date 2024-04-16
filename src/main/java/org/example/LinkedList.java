package org.example;


import java.util.NoSuchElementException;

public class LinkedList {

    // Fields
    private Node head;
    private Node tail;
    private int numberOfTasks;
    private final int maxSize;

    // default constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.numberOfTasks = 0;
        this.maxSize = 10;
    }
    // constructor that accepts a maximum size
    public LinkedList(int maxSize) {
        this.head = null;
        this.tail = null;
        this.numberOfTasks = 0;
        this.maxSize = maxSize;
    }
    public int size() {
        return numberOfTasks;
    }

    public boolean isEmpty() {
        return numberOfTasks == 0;
    }

    public boolean isFull() {
        return numberOfTasks == maxSize;
    }

    private int calcPosition(Task taskToBeAdded) {
        // Go through the linked list to find the appropriate position based on the task's deadline
        Node current = head;
        int position = 0;

        while (current != null && taskToBeAdded.compareTo(current.getData()) > 0) {
            current = current.getNext();
            position++;
        }

        // If the task is already present in the queue, throw DuplicateElementException
        if (current != null && taskToBeAdded.equals(current.getData())) {
            throw new DuplicateElementException("Task already exists in the queue");
        }

        return position;
    }






















    protected static class Node {
        // Fields
        private Task data;
        private Node next;

        public Node(Task data) {
            this.data = data;
            this.next = null;
        }

        //Setters and Getters

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public void setData(Task data) {
            this.data = data;
        }

        public Task getData() {
            return this.data;
        }
    }


}

