package org.example;

import java.time.LocalDate;

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










}