package com.stir.cscu9t4practical1;

import static java.lang.Math.round;

public class SprintEntry extends Entry
{
	private int repetitions;
	private int recovery;
	
	/**
	 * Constructor
	 * @param n Name
	 * @param d Day
	 * @param m Month
	 * @param y Year
	 * @param h Hours
	 * @param min Minutes
	 * @param s Seconds
	 * @param dist Distance
	 * @param repetitions Repetitions around track
	 * @param recovery Recovery: Time between repetitions
	 */
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery)
	{
		super(n, d, m, y, h, min, s, dist);
		this.repetitions = repetitions;
		this.recovery = recovery;
	}
	
	/**
	 * Gets a sprint entry and concatenates it into a string
	 * @return String, format: "Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n"
	 */
	@Override
	public String getEntry ()
	{
		String result = getName() + " sprinted " + getRepetitions() + "x" + round(getDistance()) +"m in "
				+ getHour() + ":" + getMin() + ":" + getSec() + " with " + getRecovery() + " minutes recovery on " +
				+ getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		
		return result;
	}
	
	/** @return Number of repetitions (track loops) done */
	public int getRepetitions()
	{
		return repetitions;
	}
	
	/** @return Minutes between each repetition */
	public int getRecovery()
	{
		return recovery;
	}
}
