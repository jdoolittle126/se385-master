package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * 
 * Boilerplate code for creating a basic JavaFX application. This is a reusable template that will be built upon and improved
 * as the term progresses.
 *
 * @author Jonathan Doolittle
 * @version 0.1 - May 17, 2021
 *
 */
public class CandyCalculatorApplication extends Application {

	// ******************************
	// Variables
	// ******************************

	/*
	 * The title as it appears on the application window
	 */
	private static final String TITLE = "Candy Bar Calculator";

	// The primary stage for this application
	private Stage stage;

	// The root element (Size can be changed in BaseApplication.fxml)
	private VBox root;


	@Override
	public void start(Stage primaryStage) {
		try {

			// Sets the primary stage
			this.stage = primaryStage;
			// Load root element from FXML file
			this.root = FXMLLoader.load(getClass().getResource("BaseApplication.fxml"));

			// Build our scene from the root
			Scene scene = new Scene(root);

			// Configure the application and show the window
			configureStage();
			stage.setScene(scene);
			stage.show();

			// Place the main FXML in our root element
			loadApplication();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Configures some basics concerning how the application should run, such as resizability 
	 */
	public void configureStage() {
		stage.setTitle(TITLE);
		stage.setResizable(false);
	}

	/*
	 * Loads the main application via FXML file
	 */
	public void loadApplication() {
		try {
			root.getChildren().add(FXMLLoader.load(getClass().getResource("../application/CalculatorInterface.fxml")));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Launches the JavaFX application
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
