package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
				int size = 512;
			    primaryStage.setTitle( "Hi Scott" );
			 
			    Group root = new Group();
			    Scene theScene = new Scene( root );
			    primaryStage.setScene( theScene );
			 
			    Canvas canvas = new Canvas( size, size );
			    root.getChildren().add( canvas );
			 
			    GraphicsContext gc = canvas.getGraphicsContext2D();
			    gc.setFill( Color.BLACK );
			    Image earth = new Image(getClass().getResource("earth.png").toString());
			    Image sun = new Image( getClass().getResource("sun.png").toString() );
			    Image moon = new Image( getClass().getResource("moon.png").toString() );
			    Image mars = new Image( getClass().getResource("mars.png").toString() );
			 
			    int offset = (size/2)-32;
			    
			    final long startNanoTime = System.nanoTime();
			    
			    new AnimationTimer()
			    {
			    	double degree = 0;
			        public void handle(long currentNanoTime)
			        {
			            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
			            gc.fillRect(0,0, 512,512);
			            double x = offset + 128 * Math.cos(t);
			            double y = offset + 128 * Math.sin(t);
			            double xx = (x) + 48 * Math.cos(t);
			            double yy = (y) + 48 * Math.sin(t);
			            double xxx = offset+ 275 * Math.cos(t/2);
			            double yyy = offset+ 250 * Math.sin(t/2);
			            degree = 10*t;
			            gc.save();
			            gc.translate(size/2, size/2);
			            gc.rotate(degree);
			            gc.drawImage( sun, -32, -32 );
			            gc.restore();
			            gc.drawImage( earth, x, y );
			            gc.drawImage( moon, xx, yy );
			            gc.drawImage( mars, xxx, yyy );
			            
			        }
			    }.start();
			    
			    System.out.println();
			 
			    primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
