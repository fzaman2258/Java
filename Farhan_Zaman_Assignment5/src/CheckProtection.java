import java.util.Scanner;
public class CheckProtection
{
	public static void main(String args[])
	{
		Scanner in =new Scanner(System.in);
		System.out.println("Enter Amount that is less than 100,000.00:");
		String input=in.nextLine();	
		try
		{	
			if(input.contains("."))						// if user themselves inserted decimal
			{
				Double num=Double.parseDouble(input);		//string becomes double keeps "."
				if(num.doubleValue()>999.99)				//handles cases of commas
				{
					int count= 8-input.length();			//its 9-1=8 because of the comma
					for(int i=0; i<count; i++)
					{
						System.out.print("*");
					}
					
					System.out.print(num.intValue()/1000);
					System.out.print(",");
					
					if(num.intValue()%1000==0)				// numbers like 1000
					{
						System.out.print("000");
					}
					
					else
					{
						System.out.print(num.intValue()%1000);	// print normal
					}
					
					if((num.doubleValue()*100)%100 ==0)		// case of .00 
					{
						System.out.print(".00");
					}
					else									// every other .xy
					{
						System.out.print(".");
						int temp;
						temp= (int)(num.doubleValue()*100)%100;		//type cast to rid the extra decimal
						System.out.print(temp);	
					}
				}
				else									// no commas needed
				{
					int count= 9-input.length();		// all 9 spaces because no comma
					for(int i=0; i<count; i++)
					{
						System.out.print("*");
					}	
					if((num.doubleValue()*100)%100 ==0)		// case of .00 
					{
						System.out.print(num.doubleValue());
						System.out.print("0");
					}
					else									// every other .xy
					{
						System.out.print(num.doubleValue());	
					}
				}
				
				
			}
			else											// no decimal in input
			{
				Integer num=Integer.parseInt(input);
				int number=num.intValue();
				if(num.intValue()>999)					// handle comma
				{
					int count=5-input.length();			//9-3-1=5 (3 for decimal 1 for comma)
					for(int i=0; i<count; i++)
					{
						System.out.print("*");
					}
					System.out.print(number/1000);		//print everything before comma
					System.out.print(",");
					if (number%1000==0)					// numbers like 1000
					{
						System.out.print("000");
					}
					else
					{
						System.out.print(number%1000);	// 1234
					}
				
					System.out.print(".00"); 			// since no decimal inputed everything is .00
				}
				else									// no commas
				{
					int count=6-input.length();
					for(int i=0; i<count; i++)
					{
						System.out.print("*");
					}
					System.out.print(num.intValue());
					System.out.print(".00");
				}	
			}
		}
		catch(NumberFormatException e)			// if they entered non-numbers
		{
			System.out.println("You entered incorrectly, please enter only numbers!");
		}
	}
}