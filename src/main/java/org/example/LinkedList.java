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

