package application;

/**
 * 
 * @author Jonathan Doolittle
 * 
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;

public class Calculator {

    @FXML
    private ChoiceBox<?> choiceActivity;

    @FXML
    private Spinner<?> spinnerWeight;

    @FXML
    private Spinner<?> spinnerHeight;

    @FXML
    private Spinner<?> spinnerAge;

    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    private Button buttonCalculate;

    @FXML
    private Label labelResult;

    @FXML
    void calculateResult(ActionEvent event) {

    }
    
    
	/**
	 * Provides context for gender values
	 */
	public enum Gender {
		MALE,
		FEMALE
	}
	
	//Our generic error message
	public static final String INPUT_REPEAT_PROMPT = "Hmm, that doesn't look quite right. Lets try again. >";
	

	
	/**
	 * The logic of the exercise
	 * @param scanner The scanner to gather data from
	 * @throws Exception 
	 */
	private static void gatherInput(Scanner scanner) throws Exception {
		
			System.out.println("This program will calculate the number of 230 calorie candy bars to eat to maintain your weight.");
			
			//Use the helper functions to gather input & calculate the value
			float value = (harrisBenedictEstimate(gatherAge(scanner),
					gatherHeight(scanner),
					gatherWeight(scanner), 
					gatherGender(scanner)) * gatherActivity(scanner)) / 230.0f;
			
			//Display value
			System.out.println(String.format("It would take %.2f candy bars to maintain your weight.", value));
		
	}

	/**
	 * Gathers the user's age (years)
	 * @param scanner The scanner to gather data from
	 * @return The age as a float
	 */
	private static float gatherAge(Scanner scanner) {
		System.out.println("What is your age in years? >");
		return gatherFloat(scanner);
	}
	
	/**
	 * Gathers the user's height (inches)
	 * @param scanner The scanner to gather data from
	 * @return The height as a float
	 */
	private static float gatherHeight(Scanner scanner) {
		System.out.println("What is your height in inches? >");
		return gatherFloat(scanner);
		
	}
	
	/**
	 * Gathers the user's weight (pounds)
	 * @param scanner The scanner to gather data from
	 * @return The weight as a float
	 */
	private static float gatherWeight(Scanner scanner) {
		System.out.println("What is your weight in pounds? >");
		return gatherFloat(scanner);
	}
	
	/**
	 * Gathers the user's gender (M/F only)
	 * @param scanner The scanner to gather data from
	 * @return The gender as a Gender enum
	 */
	private static Gender gatherGender(Scanner scanner) throws Exception {
		System.out.println("What is your gender (M/F)? >");
		
		switch(gatherChar(scanner, "MF")) {
			case 'M':
				return Gender.MALE;
			case 'F':
				return Gender.FEMALE;
			default:
				throw new Exception("No estimate calculation is mapped with this gender");
		}
		
	}
	
	/**
	 * Gathers the user's activity level
	 * @param scanner The scanner to gather data from
	 * @return The activity as a float representing the impact on BMR (ex - 20% increase returns 1.2f)
	 */
	private static float gatherActivity(Scanner scanner) throws Exception {
		System.out.println("Are you:\nA Sedentary\nB Somewhat active (exercise occasionally)\nC Active (exercise 3-4 days per week)\nD Highly active (exercise every day) \n Enter A B C or D >");
		
		switch(Character.toUpperCase(gatherChar(scanner, "ABCDabcd"))) {
			case 'A':
				return 1.2f;
			case 'B':
				return 1.3f;
			case 'C':
				return 1.4f;
			case 'D':
				return 1.5f;
			default:
				throw new Exception("Activity level unknown!");
		}
		
	}
	
	/**
	 * Gathers a float from the user. Asks until a valid float is gathered
	 * @param scanner The scanner to gather data from
	 * @return The float value
	 */
	private static float gatherFloat(Scanner scanner) {
		try {
			return scanner.nextFloat();
		} catch (InputMismatchException e) {
			System.out.println(INPUT_REPEAT_PROMPT);
			scanner.next();
			return gatherFloat(scanner);
		}
	}
	
	
	/**
	 * Gathers a char from the user. Asks until the char provided matches a char in the options string.
	 * @param scanner The scanner to gather data from
	 * @param options A string representing the possible values. (ex - A, B, C, or D would be "ABCD")
	 * @return The char
	 */
	private static char gatherChar(Scanner scanner, String options) {
		
		String value = scanner.next();
		
		if(value.length() == 1 && options.contains(value)) {
			return value.charAt(0);
		} else {
			System.out.println(INPUT_REPEAT_PROMPT);
			return gatherChar(scanner, options);
		}
	}
	
	/**
	 * This function calculates BMR based on the original 1918-1919 Harris-Benedict BMR
	 * Equations. (see: https://en.wikipedia.org/wiki/Harris%E2%80%93Benedict_equation)
	 * @param ageYr The person's age in years (float)
	 * @param heightIn The person's height in inches (float)
	 * @param weightLb The person's weight in pounds (float)
	 * @param gender The person's gender (Gender)
	 * @return The BMR of the person.
	 * @throws Exception Undefined Gender
	 */
	private static float harrisBenedictEstimate(float ageYr, float heightIn, float weightLb, Gender gender) throws Exception {
		
		switch(gender) {
			case MALE:
				return 66 + (6.3f * weightLb) + (12.9f * heightIn) - (6.8f*ageYr);
			case FEMALE: 
				return 655 + (4.3f * weightLb) + (4.7f * heightIn) - (4.7f*ageYr);
			default:	
				throw new Exception("No estimate calculation is mapped with this gender");
		}
		
	}
	
	
	
}
