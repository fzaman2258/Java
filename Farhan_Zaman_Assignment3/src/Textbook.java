import java.util.Date;
public class Textbook extends Item
{
	private String author;
	
	public Textbook(String id, String title, Date addedON, String author)
	{
		super(id, title, addedON);
		this.setAuthor(author);
	}

	public String getAuthor() 
	{
		return author;
	}

	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	@Override
	public String toString() 
	{
		return "("+this.getId()+", "+this.getTitle()+","+this.getAddedON()+", "+author+")";
	}

}
