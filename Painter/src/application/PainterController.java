package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class PainterController 
{
	private enum PenSize
	{
		SMALL(2),
		MEDIUM(4),
		LARGE(6);
		private final int radius;
		PenSize(int radius)
		{
			this.radius=radius;
		}
		public int getRadius()
		{
			return radius;
		}
	};
	private PenSize radius=PenSize.MEDIUM;
	private Paint brushColor=Color.BLACK;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private Button clearButton;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private RadioButton largeRadioButton;

    @FXML
    private RadioButton greenRadioButton;

    @FXML
    private RadioButton redRadioButton;

    @FXML
    private RadioButton blackRadioButton;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private RadioButton blueRadioButton;

    @FXML
    private RadioButton smallRadioButton;

    @FXML
    private Button undoButton;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) 
    {
    	Circle newCircle=new Circle(event.getX(), event.getY(),radius.getRadius(), brushColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent event) 
    {
    	brushColor=(Color)colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) 
    {
    	radius=(PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonPressed(ActionEvent event) 
    {
    	int count= drawingAreaPane.getChildren().size();
    	if(count>0)
    	{
    		drawingAreaPane.getChildren().remove(count-1);
    	}
    }

    @FXML
    void clearButtonPressed(ActionEvent event) 
    {
    	drawingAreaPane.getChildren().clear();
    }

    public void initialize()
    {
    	blackRadioButton.setUserData(Color.BLACK);
    	redRadioButton.setUserData(Color.RED);
    	greenRadioButton.setUserData(Color.GREEN);
    	blueRadioButton.setUserData(Color.BLUE);
    	smallRadioButton.setUserData(PenSize.SMALL);
    	mediumRadioButton.setUserData(PenSize.MEDIUM);
    	largeRadioButton.setUserData(PenSize.LARGE);
    }
}
