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


    /**
     * Gets the number of tasks currently stored in the linked list
     * @return number of tasks
     */
    public int size() {
        return numberOfTasks;
    }


    /**
     * Checks if the linked list is empty
     * @return true if its empty, false otherwise
     */
    public boolean isEmpty() {
        return numberOfTasks == 0;
    }


    /**
     * Checks if the linked list is full
     * @return true if it is full, false otherwise
     */
    public boolean isFull() {
        return numberOfTasks == maxSize;
    }


    /**
     * Calculates position to insert a task into the linked list based on the deadline.
     * @param taskToBeAdded task to be added to the linked list
     * @return position where task should be inserted
     * @throws DuplicateElementException if task is already present
     */
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


    /**
     * Adds a task to the linked list in the appropriate position
     * @param taskToBeAdded the task to be added
     * @throws IllegalArgumentException if task is null
     * @throws IllegalStateException if the linked list is full
     */
    public void add(Task taskToBeAdded) {
        // Null check
        if (taskToBeAdded == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        // isFull() check
        if (isFull()) {
            throw new IllegalStateException("The queue is full");
        }

        int position = calcPosition(taskToBeAdded);
        Node newNode = new Node(taskToBeAdded);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            // Go through the linked list to find the appropriate position based on the task's deadline
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            // Insert the new node at the appropriate position
            newNode.setNext(current.getNext());
            // Set the previous node's next pointer to the new node'
            current.setNext(newNode);
        }
        numberOfTasks++;
    }


    /**
     * Offers a task to the linked list in a certain manner
     * @param taskToBeAdded task to be added
     * @return true if the task wad added, false otherwise
     * @throws IllegalArgumentException if task is null
     * @throws IllegalStateException if the linked list is full
     */
    public boolean offer(Task taskToBeAdded) {
        if (taskToBeAdded == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        if (isFull()) {
            throw new IllegalStateException("The queue is full");
        }

        int position = calcPosition(taskToBeAdded);
        Node newNode = new Node(taskToBeAdded);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        numberOfTasks++;
        return true;
    }


    /**
     * Retrieves the first task in the linked list without removing it
     * @return the first task in the linked list
     * @throws NoSuchElementException if the linked list is empty
     */
    public Task element() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return head.getData();
    }

    /**
     * Retrieves and removes the first task in the linked list
     * @return the first task in the linked list
     * @throws NoSuchElementException if linked list is empty
     */
    public Task poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        Task firstTask = head.getData();
        head = head.getNext();
        numberOfTasks--;
        return firstTask;
    }


    /**
     * Retrieves the first task in the linked list without removing it
     * @return first task in the linked list or null if linked list is empty
     */
    public Task peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return head.getData();
    }


    /**
     * Retrieves and removes the first task in the linked list
     * @return first task in the linked list or null if linked list is empty
     */
    public Task remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        Task firstTask = head.getData();
        head = head.getNext();
        numberOfTasks--;
        return firstTask;
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

