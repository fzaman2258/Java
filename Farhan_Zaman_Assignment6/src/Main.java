import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Main
{
	public static void main (String[] args)
	{
		Scanner input= new Scanner(System.in);
		System.out.println("Enter whole number");
		int number=input.nextInt();
		int temp=number;
		boolean prime=true;				// keep track if input is prime
	/*	while(number<2)			// numbers less than 2 can't be prime by definition
		{
			System.out.println("Please enter a positive whole number");
			number=input.nextInt();
		}
	*/
		if(number<2 && number>=0)				// special cases
		{
			System.out.println("The only factor is "+number);
			return;
		}
		if(number<0)			// handle negative inputs
		{
			number *= -1;
			prime=false;			// can't be prime by definition, but have prime factors
		}

		Set<Integer> set=new TreeSet<Integer>(); //sorts and stores unique factors for us
		for(int i=2; i<number; i++)
		{
			if(number%i==0)					// if it has any other factors not prime
			{			
				prime=false;
			}
		}
		if(prime==true)
		{
			System.out.println("This number is a prime and has factors 1 and "+number);
			return;
		}
		else
		{
			while(number%2==0)					//only even prime factor
			{
				number /=2;
				set.add(2);
			}
			for(int i=3; i<=Math.sqrt(number); i+=2)	//rest of prime factors are odd
			{
				while(number%i==0)
				{
					number /=i;
					set.add(i);
				}
				
			}
		}
		if(number>2)	//the remaining number is a prime number 
		{
			set.add(number);
		}
		System.out.println("These are the unique prime factors of "+temp+": "+set);
	}
}