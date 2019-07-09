import java.util.Date;
public class CD extends MultiMediaItem
{
	private String artist;

	public CD(String id, String title, Date addedOn, int playingTime, String artist)
	{
		super(id,title,addedOn,playingTime);
		this.setArtist(artist);
	}
	public String getArtist() 
	{
		return artist;
	}

	public void setArtist(String artist) 
	{
		this.artist = artist;
	}
	
	@Override
	public String toString() 
	{
		return "("+this.getId()+", "+this.getTitle()+","+this.getAddedON()+", "+artist+")";
	}

}
