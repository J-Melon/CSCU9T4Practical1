// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;
import java.util.*;

public class TrainingRecord
{
	private List<Entry> tr;
	
	public TrainingRecord()
	{
		tr = new ArrayList<Entry>();
	}
	
	//Add a unique record to the list
	public String addEntry(Entry e)
	{
		for (Entry ent : tr)
		{
			if (e.getEntry().equals(ent.getEntry()))
			{
				return "Entry not unique. Try again.";
			}
		}
		
		tr.add(e);
		return "Record added\n";
	}
	
	//Look up the entry of a given day and month
	public String lookupEntry (int d, int m, int y)
	{
		ListIterator<Entry> iter = tr.listIterator();
		String result = "No entries found";
		while (iter.hasNext())
		{
			Entry current = iter.next();
			if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
			{
				result = current.getEntry();
			}
		}
		
		return result;
	}
	
	//Looks up all entries of a given day and month
	public String lookupAllEntry (int d, int m, int y)
	{
		ListIterator<Entry> iter = tr.listIterator();
		StringBuilder result = new StringBuilder();
		while (iter.hasNext())
		{
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
			{
				result.append(current.getEntry());
			}
		}
		
		return result.toString();
	}
	
	//Count the number of entries
	public int getNumberOfEntries()
	{
		return tr.size();
	}
	
	//Clear all entries
	public void clearAllEntries()
	{
		tr.clear();
	}
}