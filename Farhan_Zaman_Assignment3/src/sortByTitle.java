import java.util.Comparator;

public class sortByTitle implements Comparator
{
	@Override
	public int compare(Object entry1, Object entry2) 
	{
		if(entry1 instanceof String &&entry2 instanceof String) 
		{
			String s1 = (String)entry1;
			String s2 = (String)entry2;
			return s1.compareTo(s2);
		}
			return 0;
	}

}
