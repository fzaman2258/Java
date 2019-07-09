public class Navigator 
{
	private int iterations;
	
	public Navigator(int period)
	{
		iterations=period;
	}
	public void Navigate(TreeFactory T)				//traverse through the tree
	{
		btNode curr=T.getRoot();
		int time=0;
		while(time!= iterations)					//user inputs how many iterations
		{
			int temp=(int)(Math.random()*100);		//math.random gives 0-1, so make those numbers 100* bigger and int them to compare with the probability
			
			if(temp<=T.getProbability())			//if the random number is inbetween 0-P inclusive then stock goes up
			{
				time++;
				curr=curr.getUp();
				System.out.println("Time period: "+ time+
								   " Random number is: "+temp+" The stock went up!");
			}
			else
			{
				time++;
				curr=curr.getDown();
				System.out.println("Time period: "+ time+
						   " Random number is: "+temp+" The stock went down!");
			}
		}
	}
}