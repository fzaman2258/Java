import java.util.ArrayList;
import java.util.Collection;
public class Database 
{
	 private ArrayList<Item> item=new ArrayList<Item>();
	 
	 public Database()
	 {
		 
	 }
	 public Database(ArrayList<Item> entry)
	 {
		 this.item.addAll(entry);
	 }
	 
	 public ArrayList getItem()
	 {
		 return item;
	 }
	 public void setItem(ArrayList<Item> entry) 
	 {
		 this.item=entry;
	 }
	 public void addItem(Item entry)
	 {
		 this.item.add(entry);
	 }
	 public void list()
	 {
		 for(int i=0; i<item.size(); i++)
		 {
			
			 System.out.println(item.get(i));
		 }
	 }
}
