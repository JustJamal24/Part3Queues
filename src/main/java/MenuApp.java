import org.example.BoundedPriorityQueueSet;
import org.example.DuplicateElementException;
import org.example.Task;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class MenuApp {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Random rg = new Random();

      boolean risky = rg.nextBoolean();

        System.out.println("Hello, Please enter what size you would like your queue to be: ");
        int maxSize = sc.nextInt();



        BoundedPriorityQueueSet taskQueue = new BoundedPriorityQueueSet(maxSize);


        int choice;
        do{
            System.out.println("1. Add a new Task.");
            System.out.println("2. View the next Task.");
            System.out.println("3. Mark the next Task as done.");
            System.out.println("4. View the number of Tasks remaining.");
            System.out.println("5. View the space remaining in the queue.");
            System.out.println("6. Exit the program.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();


            switch (choice){
                case 1:
                sc.nextLine();
                    System.out.println("Enter owner: ");
                    String owner = sc.nextLine();
                    System.out.println("Enter description: ");
                    String description = sc.nextLine();
                    System.out.println("Enter deadline (DD-MM-YYYY): ");
                    String deadline = sc.nextLine();
                    //parse LocalDate for user input
                    Task task = new Task(owner, description, LocalDate.parse(deadline));

                    try{
                        if(risky){
                            taskQueue.add(task);
                        }else{
                            taskQueue.offer(task);
                        }
                        System.out.println("Task successfully added ");
                    } catch (DuplicateElementException e){
                        System.out.println("Failed to add task: " + e.getMessage());
                    }
                    break;










            }







        }








    }








}
