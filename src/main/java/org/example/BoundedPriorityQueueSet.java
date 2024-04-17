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

    public boolean offer(Task task){
        if(isFull()){
            //if the queue is full, return false
            return false;
        }
        //calls add method from LinkedList and adds the task
        super.add(task);
        return true;
    }

    public Task element(){
        return super.element();
    }

    public Task poll(){
        return super.poll();
    }

    public Task peek(){
        return super.peek();
    }

    public Task remove(){
     return super.remove();
    }



















}
