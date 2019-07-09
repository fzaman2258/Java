import java.util.Comparator;
import java.util.Date;
public class sortByAddedOn implements Comparator
{
	@Override
	public int compare(Object entry1, Object entry2) 
	{
		if(entry1 instanceof Date && entry2 instanceof Date) 
		{
			Date d1 = (Date)entry1;
			Date d2 = (Date)entry2;
			return d1.compareTo(d2);
		}
		return 0;
	}

}
