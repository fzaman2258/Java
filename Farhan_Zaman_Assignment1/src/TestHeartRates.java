import java.util.Scanner;
import java.util.GregorianCalendar;

public class TestHeartRates
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.printf("Enter your first name: ");
		String firstname=input.nextLine();
		System.out.printf("Enter your last  name: ");
		String lastname=input.nextLine();
		System.out.printf("Enter the month of your birth: ");
		int month = input.nextInt();
		int origmonth=month;
		month=month-1;
		System.out.printf("Enter the date of your birth: ");
		int date=input.nextInt();
		System.out.printf("Enter the year of your birth: ");
		int year =input.nextInt();
		input.close();										// close stream
	    GregorianCalendar gc = new GregorianCalendar(year,month,date);
		try 
        {
            gc.setLenient(false);
            gc.getTime(); 					// check for valid birthday entered
        }
        catch (Exception e) 
        {
            e.printStackTrace(); 
        }
		GregorianCalendar current=new GregorianCalendar();		//default parameters is current date
		HeartRates myHR= new HeartRates(firstname, lastname, month, date, year);
		
		System.out.println("Firstname: "+myHR.getFirstName()+
						   "\nLastname: "+myHR.getLastName()+
						   "\nDate of birth: "+origmonth+
						   "/"+myHR.getDate()+
						   "/"+myHR.getYear()+
						   "\nYour age in years is: "+myHR.age(gc,current)+
						   "\nYour maximum heart rate in bpm is: "+myHR.MaxHR(gc,current)+
						   "\nYour target heart range is: "+myHR.TargetHR50(gc,current)+
						   "-"+myHR.TargetHR85(gc, current)
						  );
	}
}