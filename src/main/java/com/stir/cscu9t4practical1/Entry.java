// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry
{
	private String name;
	private Calendar dateAndTime;
	private float distance;
	
	public Entry (String n, int d, int m, int y, int h, int min, int s, float dist)
	{
		Calendar inst = Calendar.getInstance();
		inst.set(y,m-1,d,h,min,s);
		this.name = n;
		this.dateAndTime = inst;
		this.distance = dist;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public int getDay ()
	{
		return dateAndTime.get(Calendar.DATE);
	}
	
	public int getMonth ()
	{
		int month =  dateAndTime.get(Calendar.MONTH) + 1;
		return month;
	}
	
	public int getYear ()
	{
		return dateAndTime.get(Calendar.YEAR);
	}
	
	public int getHour ()
	{
		return dateAndTime.get(Calendar.HOUR);
	}
	
	public int getMin ()
	{
		return dateAndTime.get(Calendar.MINUTE);
	}
	
	public int getSec ()
	{
		return dateAndTime.get(Calendar.SECOND);
	}
	
	public float getDistance ()
	{
		return distance;
	}
	
	public String getEntry ()
	{
		String result = getName()+" ran " + getDistance() + " km in "
				+getHour()+":"+getMin()+":"+ getSec() + " on "
				+getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		
		return result;
	}
	
	
}