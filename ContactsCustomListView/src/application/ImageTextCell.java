package application;
															// Custom ListView cell factory that displays an Image and text
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ImageTextCell extends ListCell<ContactListCell> 
{
   private VBox vbox = new VBox(8.0);
   private ImageView thumbImageView = new ImageView();
   private Label label = new Label();
   																// constructor configures VBox, ImageView and Label
   public ImageTextCell() 
   {
      vbox.setAlignment(Pos.CENTER); 
      thumbImageView.setPreserveRatio(true);
      thumbImageView.setFitHeight(100.0); 
      vbox.getChildren().add(thumbImageView);
      label.setWrapText(true); 								// wrap if text too wide to fit in label
      label.setTextAlignment(TextAlignment.CENTER); 
      vbox.getChildren().add(label);
      setPrefWidth(USE_PREF_SIZE); 
   }
   																// called to configure each custom ListView cell
   @Override 
   protected void updateItem(ContactListCell item, boolean empty) 
   {
	   																// required to ensure that cell displays properly
      super.updateItem(item, empty);
      if (empty || item == null) 
      {
         setGraphic(null); 											// don't display anything
      }
      else 
      {
         thumbImageView.setImage(new Image(item.getImagepath()));
         label.setText(item.getFirstName()+" "+item.getLastName()); 				// configure Label's text
         setGraphic(vbox);														 // attach custom layout to ListView cell
      }
   }
}
