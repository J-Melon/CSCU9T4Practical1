// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry
{
	private String name;
	private Calendar dateAndTime;
	private float distance;
	
	/**
	 * Constructor
	 * @param n name
	 * @param d day
	 * @param m month
	 * @param y year
	 * @param h hours
	 * @param min minutes
	 * @param s seconds
	 * @param dist distance
	 */
	public Entry (String n, int d, int m, int y, int h, int min, int s, float dist)
	{
		Calendar inst = Calendar.getInstance();
		inst.set(y,m-1,d,h,min,s);
		this.name = n;
		this.dateAndTime = inst;
		this.distance = dist;
	}
	
	/** @return name of athlete */
	public String getName ()
	{
		return name;
	}
	
	/** @return day within date */
	public int getDay ()
	{
		return dateAndTime.get(Calendar.DATE);
	}
	
	/** @return month within date */
	public int getMonth ()
	{
		int month =  dateAndTime.get(Calendar.MONTH) + 1;
		return month;
	}
	
	/** @return year within date */
	public int getYear ()
	{
		return dateAndTime.get(Calendar.YEAR);
	}
	
	/** @return hour within training time */
	public int getHour ()
	{
		return dateAndTime.get(Calendar.HOUR);
	}
	
	/** @return minutes within training time */
	public int getMin ()
	{
		return dateAndTime.get(Calendar.MINUTE);
	}
	
	/** @return seconds within training time */
	public int getSec ()
	{
		return dateAndTime.get(Calendar.SECOND);
	}
	
	/** @return training distance */
	public float getDistance ()
	{
		return distance;
	}
	
	/**
	 * Gets an entry and concatenates it into a string.
	 * @return entry string, format: "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n"
	 */
	public String getEntry ()
	{
		String result = getName()+" ran " + getDistance() + " km in "
				+getHour()+":"+getMin()+":"+ getSec() + " on "
				+getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		
		return result;
	}
}