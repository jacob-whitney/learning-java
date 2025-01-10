/*************************************************************
 * Program Name: Lottery Numbers Assignment
 * Description: Generate a list of suggested lottery numbers
 *              using random number generation techniques
 * Date: 1/11/22
 * Author: Jacob W.
 ************************************************************/

 /***********************************************************
  * Objectives
  * Generate random numbers
  *     - Between 1 and largest number (user selected)
  *     - Generate new numbers up to the number of balls
  *       (user selected)
  *     - Exclude duplicates in the same row
  *     - Generate rows of numbers up to number of tickets
  *      (user selected)
  **********************************************************/

  import java.util.Scanner;
  import java.util.Random;

public class App {
    public static void getUserInputs(int balls, int large, int tickets) {
        /*********************************************************
         * Function Descripton: Prints directions for users to 
         * input selections for lottery tickets and test inputs 
         * within allowed ranges.
         * 
         * Parameters:
         *  - balls is an integer for the number of balls the user
         *    selected for each ticket
         *  - large is the largest possible integer selected by the 
         *    user
         *  - tickets is the integer for how many tickets the user 
         *    selected
         **********************************************************/

         // Start scanner for user input
         Scanner reader = new Scanner(System.in);

         // Get number of balls or numbers from user
         System.out.println("How many balls or numbers do you wish to pick from?");
         System.out.print("Enter a number between 3 and 7 inclusive: ");
         balls = reader.nextInt();

         // Test user input is between 3 and 7 inclusive
         for (int i = 0; i < 1; i++) {
            if (balls < 3 || balls > 7) {
                System.out.println("Try again!");
                System.out.print("Enter a number between 3 and 7 inclusive: ");
                balls = reader.nextInt();
                i--;
            } // end if
         } // end for loop

         // Get largest lottery number from user
         System.out.println("What is the largest number in the lottery?");
         System.out.print("Enter a number between 45 and 70 inclusive: ");
         large = reader.nextInt();

         // Test user input is between 45 and 70 inclusive
         for (int i = 0; i < 1; i++) {
            if (large < 45 || large > 70) {
                System.out.println("Try again!");
                System.out.print("Enter a number between 45 and 70 inclusive: ");
                large = reader.nextInt();
                i--;
            } // end if
         } // end for loop

         // Get number of tickets from user
         System.out.println("How many tickets do you want?");
         System.out.print("Enter a number between 1 and 100 inclusive: ");
         tickets = reader.nextInt();

          // Test user input is between 1 and 100 inclusive
          for (int i = 0; i < 1; i++) {
            if (tickets < 1 || tickets > 100) {
                System.out.println("Try again!");
                System.out.print("Enter a number between 1 and 100 inclusive: ");
                tickets = reader.nextInt();
                i--;
            } // end if
         } // end for loop
         
         // Confirm values
         System.out.println("Your tickets will have " + balls + " numbers");
         System.out.println("The numbers will range from 1 to " + large);
         System.out.println(tickets + " tickets will be printed");
    } // end getUserInputs

    public static float findFactorial(int number) {
        /*********************************************************
         * Function Descripton: Find the factorial of any integer
         * from 0 or above.
         * 
         * Parameters:
         *  - number is the integer this function will find
         *    the factorial of.
         **********************************************************/

         // Initialize variables
         float factorial = 1.0f;

         // Multiply every integer starting with 1
         // and ending with the number parameter
         for (int i = 1; i < number + 1; i++) {
            // If number is 0 or 1, the factorial = 1
            if (number <= 1) {
                factorial = 1;
            // If the factorial is larger than 1, multiply
            // all integers up to that number
            } else {
                factorial *= i;
            } // end if else
         } // end for loop

         return factorial;
    } // end findFactorial

    public static void printOdds(int balls, int large) {
        /*********************************************************
         * Function Descripton: Calculate odds using the formula
         * N! / (K! * (N - K)!) where N is the largest number
         * and K is the number of balls selected
         * 
         * Parameters:
         *  - balls is an integer for the number of balls the user
         *    selected for each ticket
         *  - large is the largest possible integer selected by the 
         *    user
         **********************************************************/

         // Initialize variables
         double odds = 1.0d;
         // Using formula in description, subtracts gets N - K
         // from the denominator to be cancelled from N! in
         // the numberator
         int subtract = large - balls;

         // Multiply each integer starting with largest number
         // and ending before the subtract variable cancelled
         // from the numberator
         for (int i = large; i > subtract; i--) {
            odds *= i;
         } // end for loop

         // Complete the formula by dividing the final values of
         // the numerator and the denominator
         odds /= findFactorial(balls);

         // Print the results
         System.out.println("The odds of winning are 1 in " + odds);
    } // end printOdds

    public static void printTickets(int balls, int large, int tickets) {
        /*********************************************************
         * Function Descripton: Prints number of lottery tickets 
         * according to user input with random numbers and no
         * tickets having a duplicate number.
         * 
         * Parameters:
         *  - balls is an integer for the number of balls the user
         *    selected for each ticket
         *  - large is the largest possible integer selected by the 
         *    user
         *  - tickets is the integer for how many tickets the user 
         *    selected
         **********************************************************/

         // Seed random number generator
         int seed = (int) (System.currentTimeMillis() / 1000);
         
    } // end printTickets
    
    public static void main(String[] args) throws Exception {
        
        // Initialize variables
        int numberOfBalls = 7;
        int largestPossibleNumber = 70;
        int numberOfTickets = 1;
        float oddsOfWinning = 0.0f;


        // Call functions
        getUserInputs(numberOfBalls, largestPossibleNumber, numberOfTickets);
        printOdds(numberOfBalls, largestPossibleNumber);
        //printTickets(numberOfBalls, largestPossibleNumber, numberOfTickets);
    }
}
