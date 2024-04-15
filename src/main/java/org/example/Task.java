package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

    // Fields
    private String owner;
    private String description;

    private LocalDate deadline;

    // Constructor
    public Task(String owner, String description, LocalDate deadline) {
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
        LocalDate today = LocalDate.now();
        // Check if deadline is before or today's date'
        // If deadline is before or today's date, then throw an IllegalArgumentException'
        if (deadline.compareTo(today) <= 0 || deadline.compareTo(today) == 0) {
            throw new IllegalArgumentException("Deadline cannot be before or equal to today's date");
        }
    }

    // Getter
    public String getOwner() {
        return owner;
    }

    // Setter
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Getter
    public String getDescription() {
        return description;
    }

    // Setter
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter
    public LocalDate getDeadline() {
        return deadline;
    }

    //Setter
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
        LocalDate today = LocalDate.now();
        // Check if deadline is before or today's date'
        // If deadline is before or today's date, then throw an IllegalArgumentException'
        if (deadline.compareTo(today) <= 0 || deadline.compareTo(today) == 0) {
            throw new IllegalArgumentException("Deadline cannot be before or equal to today's date");
        }
    }

    @Override
    public boolean equals(Object o) {
        //Checks if the object is an instance of the class
        if (this == o) return true;
        //Checks for null or if they are not the same class
        if (o == null || getClass()!= o.getClass()) return false;


        Task task = (Task) o;

        //Comparing the fields

        //Not null check
        if(owner != null){
            //Fields are equal check
            if(!owner.equals(task.owner)){
                return false;
            }
        //If not null check is false then check if the owner field of the task object is not null
        } else if(task.owner!= null){
            return false;
        }

        //Not null check
        if(description != null){
            //Fields are equal check
            if(!description.equals(task.description)){
                return false;
            }
        //If not null check is false then check if the description field of the task object is not null
        } else if(task.description!= null){
            return false;
        }

        //Not null check
        if(deadline != null){
            //Fields are equal check
            if(!deadline.equals(task.deadline)){
                return false;
            }
        //If not null check is false then check if the deadline field of the task object is not null
        } else if(task.deadline!= null){
            return false;
        }
        //If all the fields are equal then return true
        return true;
    }

    //Returns a hash code value for the object based on its fields.
    @Override
    public int hashCode() {
        return Objects.hash(owner, description, deadline);
    }

    // A toString() method.
    @Override
    public String toString() {
        return "Task { " +
                "owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline + " " +
                '}';
    }




















}