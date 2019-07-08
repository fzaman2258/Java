/* This class contains main method to load FXML file and create GUI and attach GUI to Scene and display on 
 * Stage. The starting point is Application launch which calls its subclass start method*/

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class TipCalculator extends Application 
{
	@Override
	public void start(Stage stage) throws Exception
	{
		Parent root= FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));  //load returns root node
		Scene scene = new Scene(root);		//scene graph to scene
		stage.setTitle("Tip Calculator");	//title
		stage.setScene(scene);				//scene to stage
		stage.show();						//display stage
	}
	
	public static void main(String[] args) 
	{
		launch(args);		//Create tip calculator object and call its start method
	}
}
