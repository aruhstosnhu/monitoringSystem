/*
* This class file supports the MAIN method file, "MonitoringSystem". Here,
* information is read from the "animals.txt" file. This information consists of
* the animal's name, temperature, and food source, and feeding schedule. The code for
* a dialog box is also located here.
 */
package monitoringSystem;

//Required libraries for this class file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.*;

/**
* @author atruh
* Author: Angela Ruhstorfer
* IT 145 Final Project
* Monitoring System : Monitor Animals Class file
* Southern New Hampshire University
*/
public class MonitorAnimals {

    public static void monitorAnimal() throws IOException {

        Scanner scanner = new Scanner(System.in);

        //Declare variables, reader, and map/hashmap used in monitorAnimal method
        int choice;
        int count = 0;
        BufferedReader br = null;
        Map<Integer, String> animals = new HashMap<>();

        //Print Animal Menu Message and Title
        System.out.println("\nMonitor Animals: Choose the animal you want to monitor: ");
        System.out.println("\n\t------ Animals ------");

        /*
         * Try-Catch statement for reading and parsing information located in the
         * animals.txt file
         */
        try {
            //Declare string and read "animals.txt" text file for list of animals
            String animalCurrentLine;
            br = new BufferedReader(new FileReader("C:\\Users\\atruh\\eclipse-workspace\\monitoringSystem\\src\\monitoringSystem\\animals.txt"));

            
            while ((animalCurrentLine = br.readLine()) != null) {

                //If statement - If the line starts with "Details on", print
                if (animalCurrentLine.startsWith("Details on")) {

                    String animal = animalCurrentLine.split(" ")[2];
                    System.out.println("\t" + ++count + ". " + animal);
                    animals.put(count, animal);
                }
            }

            br.close();

            //Reads "animals.txt" text file again for detailed animal information
            br = new BufferedReader(new FileReader("C:\\Users\\atruh\\eclipse-workspace\\monitoringSystem\\src\\monitoringSystem\\animals.txt"));

            //Prompts user for input then stores int choice as the user's input
            System.out.print("\nEnter choice : ");
            choice = scanner.nextInt();
            System.out.println();

            //Declare string selectedAnimal
            String selectedAnimal = animals.get(choice);

            //Continues to read lines until there is a new line with no data
            while ((animalCurrentLine = br.readLine()) != null) {

                /*
                 * If statement - Print the animal information that
                 * corresponds with the user's choice
                 */
                if (animalCurrentLine.startsWith("Animal") && (animalCurrentLine.split(" ")[2].equalsIgnoreCase(selectedAnimal) || selectedAnimal.startsWith(animalCurrentLine.split(" ")[2].toLowerCase()))) {

                    //Continues to read lines until there is a new line with no data
                    for (int i = 0; i < 5; i++) {
                        /*
                         * If statement - if the line starts with an asterisk,
                         * display line in a pop-up dialog box
                         */
                        if (animalCurrentLine.startsWith("*")) {
                            String lineA = animalCurrentLine.replaceAll("\\*", "");
                            final JDialog dialog = new JDialog();
                            dialog.setAlwaysOnTop(true);
                            JOptionPane.showMessageDialog(dialog, lineA, "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
                         /*
                         * Printing all other animal info lines that don't
                         * begin with the asterisk
                         */
                        } else {
                            System.out.println(animalCurrentLine);
                        }
                        animalCurrentLine = br.readLine();

                    }
                }
            }

          //Used to diagnose exceptions
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
