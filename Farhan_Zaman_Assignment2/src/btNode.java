public class btNode 
{
	private btNode up;
	private btNode down;

	public btNode()			//Constructor
	{
		setUp(null);
		setDown(null);
	}
	public btNode getUp() 
	{
		return up;
	}
	public void setUp(btNode up) 
	{
		this.up = up;
	}
	public btNode getDown() 
	{
		return down;
	}
	public void setDown(btNode down) 
	{
		this.down = down;
	}
}