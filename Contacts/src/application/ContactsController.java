package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class ContactsController 
{
	private final ObservableList<ContactListCell> contacts=FXCollections.observableArrayList();
  
    @FXML
    private TextField newLastNameTextField;

    @FXML
    private TextField newFirstnameTextField;

    @FXML
    private TextField newEmailTextField;

    @FXML
    private TextField newPhoneNumberTextField;

    @FXML
    private TextField FirstNameTextField;

    @FXML
    private TextField PhoneNumberTextField;

    @FXML
    private TextField EmailTextField;
    
    @FXML
    private TextField LastNameTextField;

    @FXML
    private ListView<ContactListCell> contactListView;
    
    @FXML
    private Button deleteButton;

    @FXML
    private Button modifyButton;
    
    @FXML
    private void modifyContactButtonPressed(ActionEvent event) 
    {
    	if(newFirstnameTextField.getText().isEmpty() || newLastNameTextField.getText().isEmpty())
    	{
    		System.out.println("Don't leave the name blank! Please enter again.");
    	}
    	else if(contactListView.getSelectionModel() == null) 
    	{
    		System.out.println("Click something to modify");
    	}
    	else
    	{
	    	int index=contactListView.getSelectionModel().getSelectedIndex();		//find what they clicked and where in the list
	    	String firstname=newFirstnameTextField.getText();						//store new info
	    	String lastname=newLastNameTextField.getText();
	    	String email=newEmailTextField.getText() ;
	    	String phonenumber=newPhoneNumberTextField.getText();
	    	contacts.get(index).setFirstName(firstname);						//place new info
	    	contacts.get(index).setLastName(lastname);
	    	contacts.get(index).setEmail(email);
	    	contacts.get(index).setPhonenumber(phonenumber);
	    	contactListView.refresh();											//display changes immediately
    	}
    }

    @FXML
    private void deleteContactButtonPressed(ActionEvent event) 
    {
    	if(contacts.isEmpty())
    	{
    		System.out.println("Nothing to delete!");
    	}
    	else if(contactListView.getSelectionModel() == null) 
    	{
    		System.out.println("Click something to delete");
    	}
    	else
    	{
	    	int index=contactListView.getSelectionModel().getSelectedIndex();
	    	contacts.remove(index);														//remove the one they clicked
	    	contactListView.refresh();
    	}
    }

    @FXML
    private void newContactButtonPressed(ActionEvent event) 
    {
    	if(newFirstnameTextField.getText().isEmpty() || newLastNameTextField.getText().isEmpty())
    	{
    		System.out.println("Don't leave the name blank! Please enter again.");
    	}
    	else
    	{
	    	String firstname=newFirstnameTextField.getText();
	    	String lastname=newLastNameTextField.getText();
	    	String email=newEmailTextField.getText() ;
	    	String phonenumber=newPhoneNumberTextField.getText();
	    	contacts.add(new ContactListCell(firstname,lastname,email,phonenumber));		//constructor
	    	contactListView.setItems(contacts);												//add to ListView
    	}
    }
    	
    public void initialize()
    {
    	contactListView.getSelectionModel().selectedItemProperty().addListener			// see if they click anything on ListView
        (
            new ChangeListener<ContactListCell>() 
            {                                   
               @Override                                                     
               public void changed(ObservableValue<? extends ContactListCell> ov,   ContactListCell oldValue, ContactListCell newValue) 
               {         
                  FirstNameTextField.setText(newValue.getFirstName());
                  PhoneNumberTextField.setText(newValue.getPhonenumber());
                  EmailTextField.setText(newValue.getEmail());
                  LastNameTextField.setText(newValue.getLastName());
                  deleteButton.setDisable(false);
                  modifyButton.setDisable(false);
               }
            }
);   
    }
}
