//necessary imports for file i/o
import java.io.File;
import java.io.FileInputStream;         //"turns" the file into a read stream
import java.util.Scanner;               //reads from stream
import java.io.IOException;             //this exception must be caught and handled when dealing with streams!         
import java.io.FileOutputStream;       //"turns" the file into a write stream
import java.io.PrintWriter;            //writes to the stream
import java.io.FileNotFoundException; //this exception must be caught and handled when dealing with streams!

/****************************************/
/*				DESCRIPTION				*/
/* */
/****************************************/

public class Diary {

	public static void main(String[] args) throws IOException {

		// Needed variables
		int mm = 0;
		int dd = 0;
		int yyyy = 0;
		String prose = "";   //Empty string to read prose
		//String stoppingPoint = "stop";

		FileOutputStream fos = null;
		PrintWriter output = null;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the date as three integers separated by spaces (i.e mm dd yyyy) ");

		mm = keyboard.nextInt();
		dd = keyboard.nextInt();
		yyyy = keyboard.nextInt();

		System.out.println("Enter as many lines of prose you wish (for your to-do's list or diary entry)");
		System.out.println("Enter CTRL + Z to end the program");

		try {
			fos = new FileOutputStream(new File("diaryLog.txt"),true);
			output = new PrintWriter(fos);

			output.print("Date: " + mm + "/" + dd + "/" + yyyy);

			while(keyboard.hasNext()) {
				output.println(keyboard.nextLine());
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		} finally {
			if(output != null)
				output.close();
		}
	}
}


