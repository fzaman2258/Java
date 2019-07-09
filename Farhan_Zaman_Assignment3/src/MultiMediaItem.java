import java.util.Date;
public abstract class MultiMediaItem extends Item
{
	private int playingTime;

	public MultiMediaItem(String id, String title, Date addedOn, int playingTime)
	{
		super(id,title,addedOn);
		this.setPlayingTime(playingTime);
	}
	public int getPlayingTime() 
	{
		return playingTime;
	}

	public void setPlayingTime(int playingTime) 
	{
		this.playingTime = playingTime;
	}
	
}
