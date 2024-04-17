package org.example;

public class BoundedPriorityQueueSet  extends LinkedList {
    public BoundedPriorityQueueSet() {
        super(10);

    }
    public BoundedPriorityQueueSet(int maxSize) {
        super(maxSize);

    }

    public int size() {return super.size();}

    public boolean isEmpty(){
        return super.isEmpty();
    }



    public boolean isFull(){
        return super.isFull();
    }










}
