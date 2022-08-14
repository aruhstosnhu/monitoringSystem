/*
* This class file supports the MAIN method file, "MonitoringSystem". Here,
* information is read from the "habitats.txt" text file. This information
* consists of the habitat's name, temperature, food source, and cleanliness. 
* The code for a dialog box is also located here.
 */
package monitoringSystem;

//Require libraries for this file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.Scanner;

/**
* @author atruh
* Author: Angela Ruhstorfer
* IT 145 Final Project
* Monitoring System : Monitor Habitats Class file
* Southern New Hampshire University
*/

public class MonitorHabitats {

    public static void monitorHabitat() throws IOException {

        Scanner scanner = new Scanner(System.in);

        //Declare variables, reader, and map/hashmap used in monitorHabitat method
        int choice;
        BufferedReader br = null;
        int count = 0;
        Map<Integer, String> habitats = new HashMap<>();

        //Print Habitat Menu Message and Title
        System.out.println("\nMonitor Habitats: Choose the habitat you want to monitor: ");
        System.out.println("\n\t------ Habitats ------");

        /*
         * Try-Catch statement for reading and parsing information located in the
         * habitats.txt file
         */
        try {
            //Declare string and read "habitats.txr" text file for list of habitats
            String sCurrentLine;
            br = new BufferedReader(new FileReader("C:\\Users\\atruh\\eclipse-workspace\\monitoringSystem\\src\\monitoringSystem\\habitats.txt"));

            while ((sCurrentLine = br.readLine()) != null) {

                if (sCurrentLine.startsWith("Details on")) {
                    String habitat = sCurrentLine.split(" ")[2];
                    System.out.println("\t" + ++count + ". " + habitat);
                    habitats.put(count, habitat);
                }
            }

            br.close();
            //Reads "habitats.txt" text file again for detailed habitat information
            br = new BufferedReader(new FileReader("C:\\Users\\atruh\\eclipse-workspace\\monitoringSystem\\src\\monitoringSystem\\habitats.txt"));

            //Prompts user for input then stores int choice as the user's input
            System.out.print("\nEnter choice : ");
            choice = scanner.nextInt();
            System.out.println();

            //Declare string selectedAnimal
            String selectedAnimal = habitats.get(choice);

            
            while ((sCurrentLine = br.readLine()) != null) {
                
                /*
                 * If statement - Print the habitat information that
                 * corresponds with the user's choice
                 */
                if (sCurrentLine.startsWith("Habitat") && (sCurrentLine.split(" ")[2].equalsIgnoreCase(selectedAnimal) || selectedAnimal.startsWith(sCurrentLine.split(" ")[2].toLowerCase()))) {

                    //Continues to read lines until there is a new line with no data
                    for (int i = 0; i < 4; i++) {
                        
                        /*
                         * If statement - if the line starts with an asterisk,
                         * display line in a pop-up dialog box
                         */
                        if (sCurrentLine.startsWith("*")) {
                            String lineA = sCurrentLine.replaceAll("\\*", "");
                            final JDialog dialog = new JDialog();
                            dialog.setAlwaysOnTop(true);
                            JOptionPane.showMessageDialog(dialog, lineA, "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
                         /*
                         * Printing all other habitat info lines that don't
                         * begin with the asterisk
                         */                        
                        } else {
                            System.out.println(sCurrentLine);
                        }

                        sCurrentLine = br.readLine();

                    }
                }
            }
        //Used to diagnose exceptions
        } catch (IOException e) {
        }
    }
}
