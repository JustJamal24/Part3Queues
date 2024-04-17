package org.example;

public class BoundedPriorityQueueSet  extends LinkedList {
    public BoundedPriorityQueueSet() {
        super(10);

    }
    public BoundedPriorityQueueSet(int maxSize) {
        super(maxSize);

    }

    public int size() {return super.size();}


    public boolean isEmpty() {return super.isEmpty();}

    public boolean isFull(){
        return super.isFull();
    }

    public void add(Task task){
        if(isFull()){
            //if the queue is full, an exception is thrown
            throw new IllegalStateException("Queue is full");
        }
        super.add(task);
    }















}
