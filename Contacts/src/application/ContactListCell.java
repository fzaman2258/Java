package application;

public class ContactListCell
{
	private String FirstName;
	private String LastName;
	private String email;
	private String phonenumber;
	
	public ContactListCell(String firstname, String lastname, String email, String phonenumber)
	{
		this.FirstName=firstname;
		this.LastName=lastname;
		this.email=email;
		this.phonenumber=phonenumber;
	}
	public String getFirstName() 
	{
		return FirstName;
	}
	public void setFirstName(String firstName) 
	{
		FirstName = firstName;
	}
	public String getLastName() 
	{
		return LastName;
	}
	public void setLastName(String lastName) 
	{
		LastName = lastName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPhonenumber() 
	{
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) 
	{
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString()
	{
		return getLastName();
	}
	
}