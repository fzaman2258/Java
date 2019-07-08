package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;

public class MortgageCalculator1 extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("MortgageCalculator1.fxml"));	//root of fxml is now onto grid
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Mortgage Calculator");													//title of GUI
			primaryStage.setScene(scene);
			primaryStage.show();																			//display the GUI
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);							//calls subclass of Application aka MortgageCalcualtor and it's start function
	}
}
