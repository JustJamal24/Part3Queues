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
           displayMenu();
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
                case 2:
                    try{
                        Task nextTask = taskQueue.peek();
                        System.out.println("Next Task: " + nextTask);
                    } catch (NoSuchElementException e){
                        System.out.println("No tasks available");
                    }
                    break;
                case 3:
                    try{
                        Task finishedTask = taskQueue.poll();
                        System.out.println("Task marked as done: " + finishedTask);
                    } catch (NoSuchElementException e){
                        System.out.println("No tasks available");
                    }
                    break;
                case 4:
                    System.out.println("Number of Tasks remaining: " + taskQueue.size());
                    break;
                case 5:
                    System.out.println("Space remaining in the queue: " + (maxSize - taskQueue.size()));
                    break;
                case 6:
                    guessApproach(risky, sc);
                    break;
                default:
                System.out.println("Invalid choice. Please try again. ");
            }

        }
            while (choice != 6);
            sc.close();

    }

        public static void displayMenu(){
            System.out.println("1. Add a new Task.");
            System.out.println("2. View the next Task.");
            System.out.println("3. Mark the next Task as done.");
            System.out.println("4. View the number of Tasks remaining.");
            System.out.println("5. View the space remaining in the queue.");
            System.out.println("6. Exit the program.");
        }





        public static void guessApproach(boolean risky, Scanner sc){
            System.out.println("Do you think the approach was (1) Risky or (2) Safe");
            int guess = sc.nextInt();

            //checks if the users guess matches boolean value
            if((risky && guess == 1) || (!risky && guess == 2)){
                System.out.println("You guessed correctly, Well done!");
            } else {
                System.out.println("Incorrect guess");
            }
        }








}
