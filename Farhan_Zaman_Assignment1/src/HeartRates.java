import java.util.GregorianCalendar;
public class HeartRates
{
	private String FirstName;
	private String LastName;
	private int Month;
	private int	Date;
	private int Year;
	
	public HeartRates(String FN, String LN, int M, int D, int Y)	//Constructor
	{
		setFirstName(FN);
		setLastName(LN);
		setMonth(M);
		setDate(D);
		setYear(Y);
	}

	public String getFirstName() 
	{
		return FirstName;
	}

	public void setFirstName(String FN) 
	{
		FirstName = FN;
	}

	public String getLastName() 
	{
		return LastName;
	}

	public void setLastName(String LN) 
	{
		LastName = LN;
	}

	public int getMonth() 
	{
		return Month;
	}

	public void setMonth(int M) 
	{
		Month = M;
	}

	public int getDate() 
	{
		return Date;
	}

	public void setDate(int D) 
	{
		Date = D;
	}

	public int getYear() 
	{
		return Year;
	}

	public void setYear(int Y) 
	{
		Year = Y;
	}
	
	public int age(GregorianCalendar gc, GregorianCalendar current)
	{
		int year=current.get(GregorianCalendar.YEAR)-gc.get(GregorianCalendar.YEAR);
		int month=current.get(GregorianCalendar.MONTH)-gc.get(GregorianCalendar.MONTH);
		int date=current.get(GregorianCalendar.DATE)-gc.get(GregorianCalendar.DATE);
		
		if(month>0)		//Only months to have a birthday thus far is 1,2 so 2-1=1 2-2=0
		{
		}
		else if(month==0 && date>=0)	//Check the birthday in february to see if the date has been reached 
		{
		}
		else
		{
			year--;					// or else lower it by 1 since when doing current year-date year we overcounted
		}
		
		return year;	
	}
	
	public int MaxHR(GregorianCalendar gc, GregorianCalendar current)	//MaxHeartRate is 220 - age in years
	{
		int year=age(gc,current);
		int max=220-year;
		return max;
	}
	
	public double TargetHR50(GregorianCalendar gc, GregorianCalendar current)	//lower bound 
	{
		int max=MaxHR(gc,current);
		double lower=0.5*max;
		return lower;
	}
	
	public double TargetHR85(GregorianCalendar gc, GregorianCalendar current)		//upper bound
	{
		int max=MaxHR(gc,current);
		double higher=0.85*max;
		return higher;
	}
}