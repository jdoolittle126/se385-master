package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.util.Pair;
import javafx.util.StringConverter;

/**
 * 
 * 
 * Controller for the Candy Calculator Application. Provides event handlers and other functionality to allow
 * the application to calculate the number of 230 calorie candy bars needed to maintain a person's weight, using
 * the collected input.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 15, 2021
 *
 */
public class CalculatorController {

	// ******************************
	// Variables
	// ******************************
    
    @FXML
    private ChoiceBox<Pair<String, Float>> choiceActivity; 

    @FXML
    private Spinner<Double> spinnerWeight;

    @FXML
    private Spinner<Double> spinnerHeight;

    @FXML
    private Spinner<Integer> spinnerAge;

    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    private Button buttonCalculate;

    @FXML
    private Label labelResult;
    
    // Provides grouping for radio buttons
    private final ToggleGroup genderToggleGroup = new ToggleGroup();

	// ******************************
	// Event Handlers
	// ******************************
    
    @FXML
    /**
     * Event handler for the 'Calculate Results' button
     * @param event The ActionEvent
     */
    public void calculateResult(ActionEvent event) {
		try {
			// Use the helper functions to gather input & calculate the value by dividing by 230
			 double value = (harrisBenedictEstimate(spinnerAge.getValue(),
					spinnerHeight.getValue(),
					spinnerWeight.getValue(), 
					getGender()) * choiceActivity.getValue().getValue()) / 230.0;
			
			 // Set the label to show the result
			labelResult.setText(String.format("Result: %.2f candy bars!", value));
			
		} catch (Exception e) {
			// Feedback if an error occurs
			labelResult.setText("An error has occured");
		}
    }
    
	@FXML
	/**
	 * Called when the CalculatorInterface is instantiated. Builds the necessary values for the UI to function properly
	 */
	public void initialize() {

		// String converters that will be used in the application
		// In future builds, these utilities will be moved to a library
		
		// Pair<String, Float> string converter. Returns just the key (String) for the ChoiceBox to display,
		// and uses the value as a backing field
		StringConverter<Pair<String, Float>> pairConverter = new  StringConverter<Pair<String, Float>>() {

			@Override
			public Pair<String, Float> fromString(String string) {
				// Not implemented 
				return null;
			}

			@Override
			public String toString(Pair<String, Float> object) {
				return object.getKey();
			}

		};
		
		// Double string converter for Spinners. Returns null as opposed to throwing an error, allowing the
		// Spinner to revert to its previous state
		StringConverter<Double> doubleConverter = new StringConverter<Double>() {
			
			@Override
			public String toString(Double object) {
				return String.valueOf(object);
			}
			
			@Override
			public Double fromString(String string) {
				try {
					return Double.parseDouble(string);
				
				} catch (Exception e) {
					return null;
				}
			}
		};
		
		// Integer string converter for Spinners. Returns null as opposed to throwing an error, allowing the
		// Spinner to revert to its previous state
		StringConverter<Integer> intConverter = new StringConverter<Integer>() {
			
			@Override
			public String toString(Integer object) {
				return String.valueOf(object);
			}
			
			@Override
			public Integer fromString(String string) {
				try {
					return Integer.parseInt(string);
				
				} catch (Exception e) {
					return null;
				}
			}
		};
		
		// Set the ChoiceBox converter to the <String, Float> pair string converter
	    choiceActivity.setConverter(pairConverter);
		
	    // Build the item choices with String, Float pair combos
		choiceActivity.getItems().add(new Pair<>("Sedentary", 1.2f));
		choiceActivity.getItems().add(new Pair<>("Somewhat active (exercise occasionally)", 1.3f));
		choiceActivity.getItems().add(new Pair<>("Active (exercise 3-4 days per week)", 1.4f));
		choiceActivity.getItems().add(new Pair<>("Highly active (exercise every day)", 1.5f));
		
		// Clear and select the first item
		choiceActivity.getSelectionModel().clearAndSelect(0);
		
		// Build radio button grouping, enabling the male button so one is always selected
		radioMale.setSelected(true);
		radioFemale.setToggleGroup(genderToggleGroup);
		radioMale.setToggleGroup(genderToggleGroup);
		
		// Build the SpinnerValueFactory instances for each spinner. The factories define the spinner's behavior.
		// These are built in spinners, with extra functions added on using event listeners. Values for Weight and Height
		// are clamped between 0 and 500, and Age is clamped between 0 and 100
		spinnerWeight.valueFactoryProperty().set(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 500));
		spinnerHeight.valueFactoryProperty().set(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 500));
		spinnerAge.valueFactoryProperty().set(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
		
		// Add the converters for each spinner
		spinnerWeight.getValueFactory().setConverter(doubleConverter);
		spinnerHeight.getValueFactory().setConverter(doubleConverter);
		spinnerAge.getValueFactory().setConverter(intConverter);
		
		// Builds event listers for each spinner
		createListener(spinnerWeight);
		createListener(spinnerHeight);
		createListener(spinnerAge);
		
		
	}

	// ******************************
	// Helper Methods
	// ******************************
	
	/**
	 * Converts radio selection into {@link Gender} enum values
	 * @return The selected {@link Gender} value
	 */
    private Gender getGender() {
    	return (radioMale.isSelected()) ? Gender.MALE : Gender.FEMALE;
    }
    
	/**
	 * Builds event listeners that remove invalid input for a given node. Built to eliminate errors when allowing a
	 * {@link Spinner} to be edited. Once a {@link Spinner} loses focus, its input will be immediately validated without
	 * the need for the user to press enter. Invalid input will be reverted to its prior state.
	 * @param <T> The value the given {@link Node} is constrained to
	 * @param node The {@link Spinner} to constrain
	 */
	private static <T> void createListener(Spinner<T> node) {
		
		// Adds a focus listener to the node that forces 
		node.focusedProperty().addListener((observable, oldValue, newValue) -> {
			// Boolean.FALSE.equals allows for newValue to be null without throwing an error
			  if (Boolean.FALSE.equals(newValue)) {
				  try {
					  node.increment(0); // Forces an underlying call to update the node's value
				  } catch (Exception e) {
					  // ValueFactory was not set
				  }
			  }
			});
		
		// Adds an event listener to the value of the spinner, checking for null input returned from the
		// StringConverters. This null will be reverted to the prior value
		node.valueProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue == null) {
				// Revert value
				node.getValueFactory().setValue(oldValue);
			}
		});
		
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
	private static double harrisBenedictEstimate(double ageYr, double heightIn, double weightLb, Gender gender) throws Exception {
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
