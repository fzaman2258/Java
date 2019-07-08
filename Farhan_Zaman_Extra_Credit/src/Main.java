import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
 
public class Main extends Application 
{
    private Timeline timeline;
    private AnimationTimer timer;
    private Integer i=0;
 
    @Override public void start(Stage stage) 
    {
    	
    	Group group = new Group();
	  	Scene scene = new Scene(group);
	  	stage.setScene(scene);
	  	stage.setWidth(500);
	  	stage.setHeight(500);
	  	group.setTranslateX(80);
	  	group.setTranslateY(80);
          
    	final Rectangle rect = new Rectangle(10, 10, 100, 100);		// make a rectangle changing opacity
    	rect.setArcHeight(20);
    	rect.setArcWidth(20);
    	rect.setFill(Color.PURPLE);
    	FadeTransition ft = new FadeTransition(Duration.millis(3000), rect);
    	ft.setFromValue(1.0);
    	ft.setToValue(0.1);
    	ft.setCycleCount(Timeline.INDEFINITE);
    	ft.setAutoReverse(true);
    	ft.play();
    	
        final Ellipse ellipse= new Ellipse();
        ellipse.setRadiusX(20);
        ellipse.setRadiusY(40);
        ellipse.setEffect(new Lighting());
        final Text text = new Text (i.toString());
        text.setStroke(Color.YELLOWGREEN);
        
        final StackPane stack = new StackPane();		 //create a layout for ellipse with text inside
        stack.getChildren().addAll(ellipse,rect, text);
        stack.setLayoutX(30);
        stack.setLayoutY(30);
 
        group.getChildren().add(stack);
        stage.show();
        
        timeline = new Timeline();						//create a timeline for moving the ellipse
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
 
        timer = new AnimationTimer() 
        {
            @Override
            public void handle(long l) 
            {
                text.setText(i.toString()+"\n"+"ms");
                i++;
            }
 
        };
 
 
        KeyValue keyValueX = new KeyValue(stack.scaleXProperty(), 3);	// scales ellipse x radius by 3
        KeyValue keyValueY = new KeyValue(stack.scaleYProperty(), 3);  // scales ellipse y radius by 3
 
        Duration duration = Duration.millis(2000);
       
        EventHandler onFinished = new EventHandler<ActionEvent>()  //randomly place ellipse once its finished
        {
            public void handle(ActionEvent t) 
            {
                 stack.setTranslateX(java.lang.Math.random()*200-100);
                 stack.setTranslateY(java.lang.Math.random()*200-100);
                 i = 0;
            }
        };
 
        KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        timer.start();
    }
        
        
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
  } 