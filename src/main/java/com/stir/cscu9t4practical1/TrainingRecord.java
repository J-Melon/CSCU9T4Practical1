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
	
	/**
	 * Add a unique record to the list.
	 * @param e entry
	 * @return message
	 */
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
	
	/**
	 * Remove a record from the list based on name and date.
	 * @param n name
	 * @param d day
	 * @param m month
	 * @param y year
	 * @return message
	 */
	public String removeEntry(String n, int d, int m, int y)
	{
		for (Entry ent : tr)
		{
			if (n.equals(ent.getName()) && d == ent.getDay() && m == ent.getMonth() && y == ent.getYear())
			{
				tr.remove(ent);
				return "Entry removed.";
			}
		}
		
		return "Entry not found";
	}
	
	/**
	 * Checks whether data is a valid date.
	 * @param d day
	 * @param m month
	 * @param y year
	 * @return Bool: false = not valid, true = valid
	 */
	public Boolean isValidDate(int d, int m, int y)
	{
		int[] daysInMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		//If dates negative or 0 or month beyond calender year
		if (d <= 0 || m <= 0 || m > 12 || y <= 0)
		{
			return false;
		}
		
		if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) //If leap year
		{
			daysInMonth[1] = 29; //Change feb to 29 days
		}
		
		return d <= daysInMonth[m - 1];
	}
	
	/**
	 * Looks up a single entry of a given day and month
	 * @param d day
	 * @param m month
	 * @param y year
	 * @return message (whether is finds an entry)
	 */
	public String lookupEntry(int d, int m, int y)
	{
		ListIterator<Entry> iter = tr.listIterator();
		String result = "No entries found.";
		while (iter.hasNext())
		{
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
			{
				result = current.getEntry();
			}
		}
		
		return result;
	}
	
	/**
	 * Looks up all entries of a given day and month
	 * @param d day
	 * @param m month
	 * @param y year
	 * @return message (whether is finds entries)
	 */
	//Looks up all entries of a given day and month
	public String lookupAllEntry(int d, int m, int y)
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
		
		if (result.toString().equals("")) //If no entries found
		{
			result.append("No entries found.");
		}
		
		return result.toString();
	}
	
	/**
	 * Counts the number of entries
	 * @return number of entries
	 */
	public int getNumberOfEntries()
	{
		return tr.size();
	}
	
	/** Clears all entries */
	public void clearAllEntries()
	{
		tr.clear();
	}
}