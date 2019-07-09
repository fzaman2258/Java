public final class TreeFactory 		//final means no one else can change this
{
	private btNode root;
	private int height;
	private int probability;
	
	public TreeFactory(int depth, int probability)
	{
		setRoot(new btNode());
		setHeight(depth);
		setProbability(probability);
	}
	public btNode getRoot() 
	{
		return root;
	}
	public void setRoot(btNode root) 
	{
		this.root = root;
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
	public int getProbability() 
	{
		return probability;
	}
	public void setProbability(int probability) 
	{
		this.probability = probability;
	}
	public static void MakeTree(btNode root, int T)
	{
		if(T!=0)							//we are counting the number of iterations 
		{
			btNode A=new btNode();			
			btNode B= new btNode();
			root.setUp(A);					//expanding the tree
			root.setDown(B);	
			T--;							//every time this is reached an iteration has been completed
			MakeTree(A,T);					//recursively create the top and bottom subtrees
			MakeTree(B,T);
		}
	}
}