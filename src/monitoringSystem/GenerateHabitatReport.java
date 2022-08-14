package monitoringSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GenerateHabitatReport {

 public static void generateHabitatReport() throws IOException {
	 
	 Scanner scanner = new Scanner(System.in);
	 
	 //String command = "powershell.exe  your command";
	 //Getting the version
	 String command = "powershell -ExecutionPolicy Bypass -File C:\\Users\\atruh\\eclipse-workspace\\monitoringSystem\\src\\resources\\generatehabitatreport.ps1";
	 
	 // Executing the command
	 Process powerShellProcess = Runtime.getRuntime().exec(command);
	 
	 // Getting the results
	 powerShellProcess.getOutputStream().close();
	 String line;
	 System.out.println("Report creation in progress...");
	 BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
	 while ((line = stdout.readLine()) != null) {
		 System.out.println(line);
		 }
	 stdout.close();
	 
	 // Provide error if not able to create the report
	 BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
	 while ((line = stderr.readLine()) != null) {
		 System.out.println("There was an error in generating the report");
		 System.out.println(line);
		 }
	 stderr.close();
	 
	// Print out request completion line 
	 System.out.println("Habitat Report Request Completed");
	 
 }
}
