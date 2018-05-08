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

		PrintWriter output = null;
		PrintWriter output1 = null;
		FileInputStream fos = null;
		FileOutputStream fos1 = null;
		String userAdvice = "";

		Scanner keyboard = new Scanner(System.in);

		try {
			fos = new FileInputStream("adviceLog.txt");
			Scanner scanner = new Scanner(fos);
			
			System.out.println(scanner.nextLine());
			System.out.println("Enter advice you would give to another programmer");
			System.out.println("Press 'Enter' (Return) twice to exit");

			while(keyboard.hasNextLine()) {
				userAdvice = keyboard.nextLine();
				if(userAdvice.equals("")) {
					break;
				}else {
					output.println(userAdvice);
				}
			}

			try {
				fos1 = new FileOutputStream(new File("advice.txt"), false);
				output1 = new PrintWriter(fos1);


			}catch(FileNotFoundException fnf) {
				System.out.println("file not in directory or not spelled correct");
				System.exit(0);
			}finally {
				output1.close();
			}
			//end nested try-catch-finally
		}catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}finally {
			if(output != null)
				output.close();
		}
	}
}