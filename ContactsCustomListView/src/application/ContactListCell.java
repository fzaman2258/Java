package application;

public class ContactListCell
{
	private String FirstName;
	private String LastName;
	private String email;
	private String phonenumber;
	private String imagepath;
	
	public ContactListCell(String firstname, String lastname, String email, String phonenumber,String imagepath)
	{
		this.FirstName=firstname;
		this.LastName=lastname;
		this.email=email;
		this.phonenumber=phonenumber;
		this.imagepath=imagepath;
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
	public String getImagepath() 
	{
		return imagepath;
	}
	public void setImagepath(String imagepath) 
	{
		this.imagepath = imagepath;
	}
	@Override
	public String toString()
	{
		return getLastName();
	}
	public int compareTo(String entry)
	{
		return LastName.compareTo(entry);
	}
	
	
}