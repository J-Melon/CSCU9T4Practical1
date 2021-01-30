package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry
{
	private String where;
	
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
	 * @param where where athlete is swimming (outdoors, in a pool)
	 */
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String where)
	{
		super(n, d, m, y, h, min, s, dist);
		this.where  = where;
	}
	
	/**
	 * Gets a sprint entry and concatenates it into a string.
	 * @return swim entry string, format: "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n"
	 */
	@Override
	public String getEntry()
	{
		String result = "";
		
		//So that pool becomes "in a pool" in string
		if (getWhere().equals("pool"))
		{
			result = getName() + " swam " + getDistance() + " km in a " + getWhere() + " in "
					+ getHour() + ":" + getMin() + ":" + getSec() + " on " +
					+ getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		
		}
		
		else
		{
			result = getName() + " swam " + getDistance() + " km " + getWhere() + " in "
					+ getHour() + ":" + getMin() + ":" + getSec() + " on "
					+ getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		}
		
		return result;
	}
	
	/** @return where athlete is swimming (outdoors, in a pool) */
	public String getWhere()
	{
		return where;
	}
}
