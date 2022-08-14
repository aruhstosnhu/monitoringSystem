/*
* This is the main method class file of the SNHU ZOO monitoring system. View  
* this file as the user interface of the program. It pulls methods from the
* other class files located within the project and displays their outputs in a 
* clear and easy-to-understand way.
 */
package monitoringSystem;

//Required library for this class file
import java.io.IOException;
import java.util.Scanner;

/**
* @author atruh
* Author: Angela Ruhstorfer
* IT 145 Final Project
* Monitoring System : Monitoring System Class (MAIN) file
* Southern New Hampshire University
*/

public class MonitoringSystem {

   public static void main(String[] args) throws IOException {       
       
       try (Scanner scanner = new Scanner(System.in)) {
		//Declare variable
		   int initialChoice;
		   
		   while(true){
		       //Prints Main Menu
		       System.out.println("\t SNHU ZOO MAIN MENU");
		       System.out.println("Please select from one of the options:");
		       System.out.println("\n\t1. Monitor an animal");
		       System.out.println("\t2. Monitor a habitat");
		       System.out.println("\t3. Exit");
		       
		       //Prompts for user input and sets it to variable initialChoice
		       System.out.print("\nEnter Choice: ");
		       initialChoice = scanner.nextInt();
		       
		       /*
		       * Switch statement to either decide what method to call, exit the
		       * program, or print an error message, depending on the user's input
		       */
		       switch(initialChoice){
		       case 1:
		           //Method from class file "MonitorAnimals"
		           MonitorAnimals.monitorAnimal();
		           break;
		       case 2:
		           //Method function from class file "MonitorHabitats"
		           MonitorHabitats.monitorHabitat();
		           break;
		       case 3:
		           System.out.println("\nExiting Program...Goodbye!");
		           System.exit(0);
		       default:
		           System.out.println("\nInvalid Input. Please try again.");
		       }
		   }
	}
    }
}