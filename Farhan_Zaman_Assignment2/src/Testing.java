import java.util.Scanner;
public class Testing 
{
	public static void main(String[] args)
	{
		Scanner input= new Scanner(System.in);
		System.out.println("Enter length of tree:");
		int depth=input.nextInt();
		System.out.println("Enter amount of iterations:");
		int iterations=input.nextInt();
		System.out.println("Enter probability:");
		int probability=input.nextInt();
		input.close();
		
		TreeFactory T=new TreeFactory(depth,probability);
		T.MakeTree(T.getRoot(), depth);
		Navigator N=new Navigator(iterations);
		N.Navigate(T);
	}
}
