package utilities;
import java.util.Scanner;
import java.util.InputMismatchException;
public class InputUtil {
	private Scanner input;
	public InputUtil(){
		input = new Scanner(System.in).useDelimiter("\\n");
	 }
	//takes an in and checks if it is BELOW OR EQUAL to the lowerlimit and ABOVE the upperlimit (except when 0, in which case, no upper limit)
	public int getInt(int lowerLimit, int upperLimit) {
		int num=0;
		do {
		//loop this if input is incorrect
			try { 
				num = input.nextInt();
			 } catch(InputMismatchException e) {
				num = 0;	
			 }
			
			if(num <= lowerLimit || (num > upperLimit && upperLimit!=0)) {
				System.out.println("\nInvalid input "+ num +". Please input new value.");
				System.out.print("New value: ");
				continue;
			 }
			 break;			 
		 }while(true);	
	 	
	 	return num;
	 }
	
	public double getDouble(double lowerLimit, double upperLimit) {
		double num=-1;
		//loop if wrong input
		do {
			try { 
				num = input.nextDouble();
			 } catch(InputMismatchException e) {
			 	num = -1.0;	
			 }
			
			if(num < lowerLimit || num > upperLimit) {
				System.out.println("\nInvalid input. Please input new value.");
				System.out.print("New value: ");
				continue;
			 }
			break;
		 }while(true);
	 	return num;
	 }
	
	public String getString(int charLimit) {
		String word="";
		do {
			word = input.next();
	 		if(word.length() > charLimit) { 
	 			System.out.println("\nInput exceeds character limit.");
	 			System.out.print("New value: ");
	 			continue;
	 		} 
	 		break;
	 	} while(true);
	 	return word;
	 }

 }
