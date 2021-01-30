package com.stir.cscu9t4practical1;

import static java.lang.Math.round;

public class SprintEntry extends Entry
{
	private int repetitions;
	private int recovery;
	
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
	 * @param repetitions repetitions around track
	 * @param recovery recovery: time between repetitions
	 */
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery)
	{
		super(n, d, m, y, h, min, s, dist);
		this.repetitions = repetitions;
		this.recovery = recovery;
	}
	
	/**
	 * Gets a sprint entry and concatenates it into a string.
	 * @return sprint entry string, format: "Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n"
	 */
	@Override
	public String getEntry ()
	{
		String result = getName() + " sprinted " + getRepetitions() + "x" + round(getDistance()) +"m in "
				+ getHour() + ":" + getMin() + ":" + getSec() + " with " + getRecovery() + " minutes recovery on " +
				+ getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		
		return result;
	}
	
	/** @return number of repetitions (track loops) done. */
	public int getRepetitions()
	{
		return repetitions;
	}
	
	/** @return minutes between each repetition. */
	public int getRecovery()
	{
		return recovery;
	}
}
