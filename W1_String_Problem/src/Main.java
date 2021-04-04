import java.util.Scanner;

public class Main {
	static Scanner scanner;
	static String stringText;
	static StringBuffer stringBuffer;
	
	
	
	public static void main(String[] args) {
		 scanner = new Scanner(System.in);
		 stringText = new String();
		 stringBuffer = new StringBuffer();
		
		System.out.println("Welcome to Jon's WordGluer\u2122\n"
				+ "Lets start with your first word >");
		readInput();
		System.out.println("Good choice! How about a second word? >");
		readInput();
		System.out.println("Just one more! >");
		readInput();
		
		System.out.println(String.format("Your concatenated string is '%s' and your string buffer is '%s'", stringText, stringBuffer.toString()));
		
		scanner.close();
		
		
	}
	
	public static void readInput() {
		String temp = scanner.nextLine();
		stringText += temp;
		stringBuffer.append(temp);
	}
	
	
	
}
