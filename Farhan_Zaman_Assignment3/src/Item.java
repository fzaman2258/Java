import java.util.Date;
public abstract class Item implements Comparable<Item>
{
	private String id;
	private String title;
	private Date addedON;
	
	public Item (String id, String title, Date addedON)
	{
		this.setId(id);
		this.setTitle(title);
		this.setAddedON(addedON);
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public Date getAddedON() 
	{
		return addedON;
	}

	public void setAddedON(Date addedON) 
	{
		this.addedON = addedON;
	}
	@Override
	public int compareTo(Item entry)
	{
		return id.compareTo(entry.getId());
	}
	
	public String toString()
	{
		return "("+this.getId()+", "+this.getTitle()+","+this.getAddedON()+")";
	}
}
