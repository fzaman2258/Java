package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
//import java.awt.print.Book;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class CoverViewerController 
{
	private final ObservableList<Book> books= FXCollections.observableArrayList();
    @FXML
    private ListView<Book> booksListView;	

    @FXML
    private ImageView coverImageView;
    
    public void initialize() 
    {
        // populate the ObservableList<Book>
        books.add(new Book("Android How to Program", "/images/small/androidhtp.jpg", "/images/large/androidhtp.jpg"));
        books.add(new Book("C How to Program",  "/images/small/chtp.jpg", "/images/large/chtp.jpg"));
        books.add(new Book("C++ How to Program","/images/small/cpphtp.jpg", "/images/large/cpphtp.jpg"));
        books.add(new Book("Internet and World Wide Web How to Program",  "/images/small/iw3htp.jpg", "/images/large/iw3htp.jpg"));
        books.add(new Book("Java How to Program",  "/images/small/jhtp.jpg", "/images/large/jhtp.jpg"));
        books.add(new Book("Visual Basic How to Program", "/images/small/vbhtp.jpg", "/images/large/vbhtp.jpg"));
        books.add(new Book("Visual C# How to Program",  "/images/small/vcshtp.jpg", "/images/large/vcshtp.jpg"));
        booksListView.setItems(books); // bind booksListView to books

        // when ListView selection changes, show large cover in ImageView
        booksListView.getSelectionModel().selectedItemProperty().addListener
        (
              new ChangeListener<Book>() 
              {                                   
                 @Override                                                     
                 public void changed(ObservableValue<? extends Book> ov,Book oldValue, Book newValue) 
                 {                        
                    coverImageView.setImage(new Image(newValue.getLargeImage()));
                 }
              }
        );                                                                  
     }     
  }
