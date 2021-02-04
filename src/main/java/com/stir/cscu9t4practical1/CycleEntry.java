package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry
{
	private String terrain;
	private String tempo;
	
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
	 * @param terrain terrain of cycle surface (gravel, asphalt, mountain)
	 * @param tempo speed of cycle (fast, moderate, slow)
	 */
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo)
	{
		super(n, d, m, y, h, min, s, dist);
		this.terrain = terrain;
		this.tempo = tempo;
	}
	
	/**
	 * Gets a cycle entry and concatenates it into a string
	 * @return cycle entry string, format: "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo"
	 */
	@Override public String getEntry()
	{
		String result = getName() + " cycled " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec() + " on "
						+ getDay() + "/" + getMonth() + "/" + getYear() + " on " + getTerrain() + " at " + getTempo() + " tempo\n";
		
		return result;
	}
	
	/** @return terrain of cycle surface (gravel, asphalt, mountain) */
	public String getTerrain()
	{
		return terrain;
	}
	
	/** @return speed of cycle (fast, moderate, slow) */
	public String getTempo()
	{
		return tempo;
	}
}
