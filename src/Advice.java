import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/****************************************/
/*				DESCRIPTION				*/
/* This program will display a line of	*/
/* advice and then ask the user for a	*/
/* line of advice for the next user.	*/
/* The advice given by the user is		*/
/* stored in a file "advice.txt	and is	*/
/* overwritten with each run. The data	*/
/* submitted by each user is stored in a*/
/* separate file "adviceLog.txt			*/
/****************************************/

public class Advice {

	public static void main(String[] args) {
		//declare file objects
		PrintWriter output = null;
		FileOutputStream fos = null;
		
		Scanner keyboard = new Scanner(System.in);
		
		String userAdvice = "";

		System.out.println("Enter advice you would give to another programmer");
		System.out.println("Press 'Enter' (Return) twice to exit");
		
		try {
			fos = new FileOutputStream(new File("adviceLog.txt"),true);
			output = new PrintWriter(fos);
			
			while(keyboard.hasNextLine()) {
				userAdvice = keyboard.nextLine();
				if(userAdvice.equals("")) {
					break;
				}else {
					output.println(userAdvice);
				}	
			}
		}catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}finally {
			if(output != null)
				output.close();
		}
	}
}