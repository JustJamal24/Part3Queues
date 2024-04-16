package org.example;

public class DuplicateElementException extends RuntimeException {
    public DuplicateElementException() {
        super("You attempted to add a duplicate element to the structure" + "\n P.S. You should not have done that :/");
    }
    public DuplicateElementException(String message) {
        super(message);
    }

}
