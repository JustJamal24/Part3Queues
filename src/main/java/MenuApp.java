import org.example.BoundedPriorityQueueSet;

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









    }








}
