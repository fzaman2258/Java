package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.util.Callback;
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
    private TextField imagePathWayTextField;
    
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
    	else if(contactListView.getSelectionModel().selectedItemProperty() != null) 
    	{
    		System.out.println("Click something to modify");
    	}
    	else
    	{
	    	int index=contactListView.getSelectionModel().getSelectedIndex();
	    	String firstname=newFirstnameTextField.getText();
	    	String lastname=newLastNameTextField.getText();
	    	String email=newEmailTextField.getText() ;
	    	String phonenumber=newPhoneNumberTextField.getText();
	    	String imagepath=imagePathWayTextField.getText();
	    	contacts.get(index).setFirstName(firstname);
	    	contacts.get(index).setLastName(lastname);
	    	contacts.get(index).setEmail(email);
	    	contacts.get(index).setPhonenumber(phonenumber);
	    	contacts.get(index).setImagepath(imagepath);
	    	
	    	for(int i=0; i<contacts.size(); i++)
	    	{
	    		for(int j=i+1; j<contacts.size(); j++)
	    		{
		    		if (contacts.get(i).getLastName().compareTo(contacts.get(j).getLastName()) >0)
		    		{
		    			swap(contacts.get(i),contacts.get(j));
		    		}
	    		}
	    	}
	    	contactListView.refresh();
    	}
    }

    @FXML
    private void deleteContactButtonPressed(ActionEvent event) 
    {
    	if(contacts.isEmpty())
    	{
    		System.out.println("Nothing to delete!");
    	}
    	else
    	{
	    	int index=contactListView.getSelectionModel().getSelectedIndex();
	    	contacts.remove(index);
	    	contactListView.refresh();
    	}
    }

    @FXML
    private void newContactButtonPressed(ActionEvent event) 
    {
    	if(newFirstnameTextField.getText().isEmpty() || newLastNameTextField.getText().isEmpty() || imagePathWayTextField.getText().isEmpty())
    	{
    		System.out.println("Don't leave the name blank! Please enter again.");
    	}
    	else
    	{
	    	String firstname=newFirstnameTextField.getText();
	    	String lastname=newLastNameTextField.getText();
	    	String email=newEmailTextField.getText() ;
	    	String phonenumber=newPhoneNumberTextField.getText();
	    	String imagepath=imagePathWayTextField.getText();
	    	contacts.add(new ContactListCell(firstname,lastname,email,phonenumber,imagepath));
	    	contactListView.setItems(contacts);
	    	
	    	contactListView.setCellFactory											//making cells in listview include picture and label
    	    (
    			new Callback<ListView<ContactListCell>, ListCell<ContactListCell>>() 
    			{
    		         @Override
    		         public ListCell<ContactListCell> call(ListView<ContactListCell> listView) 
    		         {
    		            return new ImageTextCell();
    		         }
    			}
    	    ); 
	    	for(int i=0; i<contacts.size(); i++)						//sorting by last name insertion sort algorithm
	    	{
	    		for(int j=i+1; j<contacts.size(); j++)
	    		{
		    		if (contacts.get(i).getLastName().compareTo(contacts.get(j).getLastName()) >0)		//compareto returns -1,0,1
		    		{
		    			swap(contacts.get(i),contacts.get(j));								//swaps if lastname i comes after lastname j
		    		}
	    		}
	    	}
    	}
    }
    	
    public void initialize()
    {
    	contactListView.getSelectionModel().selectedItemProperty().addListener
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
               }
            }
        );    
     }

    public void swap(ContactListCell entry,ContactListCell entry2)					//swap the individual private member variables for the entries
	{
		String lastname=entry.getLastName();
		entry.setLastName(entry2.getLastName());
		entry2.setLastName(lastname);
		
		String firstname=entry.getFirstName();
		entry.setFirstName(entry2.getFirstName());
		entry2.setFirstName(firstname);
		
		String email=entry.getEmail();
		entry.setEmail(entry2.getEmail());
		entry2.setEmail(email);
		
		String phonenumber=entry.getPhonenumber();
		entry.setPhonenumber(entry2.getPhonenumber());
		entry2.setPhonenumber(phonenumber);
		
		String imagepath=entry.getImagepath();
		entry.setImagepath(entry2.getImagepath());
		entry2.setImagepath(imagepath);
	}
}
