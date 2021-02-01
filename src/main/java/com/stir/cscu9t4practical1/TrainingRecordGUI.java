// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener
{
	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	
	//CycleEntry
	private JTextField terrain = new JTextField(4);
	private JTextField tempo = new JTextField(4);
	
	//SwimEntry
	private JTextField where = new JTextField(4);
	
	//SprintEntry
	private JTextField repetitions = new JTextField(4);
	private JTextField recovery = new JTextField(4);
	
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	
	//CycleEntry
	private JLabel labTerrain = new JLabel(" Terrain:");
	private JLabel labTempo = new JLabel(" Tempo");
	
	//SwimEntry
	private JLabel labWhere = new JLabel(" Location");
	
	//SprintEntry
	private JLabel labRepetitions = new JLabel(" Repetitions:");
	private JLabel labRecovery = new JLabel(" Recovery (mins)");
	
	private JButton addR = new JButton("Add");
	private JButton lookUpByDate = new JButton("Look Up");
	
	private JButton findAllByDate = new JButton("Find All By Date");
	
	//Entry type dropdown list
	String[] entryTypes = new String[] {"Cycle", "Swim", "Sprint"};
	JComboBox<String> entryList = new JComboBox<>(entryTypes);
	
	private String entryType = "";
	
	private TrainingRecord myAthletes = new TrainingRecord();
	private JTextArea outputArea = new JTextArea(5, 70);
	
	public static void main(String[] args)
	{
		TrainingRecordGUI applic = new TrainingRecordGUI();
	}
	
	//Set up the GUI
	public TrainingRecordGUI()
	{
		super("Training Record");
		setLayout(new FlowLayout());
		
		//Combo-box
		add(entryList);
		entryList.addActionListener(this);
		entryList.setSelectedItem("Cycle"); //Sets default selected
		
		add(labn);
		add(name);
		name.setEditable(true);
		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);
		
		//CycleEntry
		add(labTerrain);
		add(terrain);
		terrain.setEditable(true);
		add(labTempo);
		add(tempo);
		tempo.setEditable(true);
		
		//SwimEntry
		add(labWhere);
		add(where);
		where.setEditable(true);
		
		//SprintEntry
		add(labRepetitions);
		add(repetitions);
		repetitions.setEditable(true);
		add(labRecovery);
		add(recovery);
		recovery.setEditable(true);
		
		add(addR);
		addR.addActionListener(this);
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		
		add(findAllByDate);
		findAllByDate.addActionListener(this);
		
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 250);
		setVisible(true);
		blankDisplay();
	}
	
	//Listen for and respond to GUI events
	public void actionPerformed(ActionEvent event)
	{
		String message = "";
		if (event.getSource() == addR)
		{
			message = addEntry();
		}
		
		if (event.getSource() == lookUpByDate)
		{
			message = lookupEntry();
		}
		
		if (event.getSource() == findAllByDate)
		{
			message = lookupAllEntry();
		}
		
		if (event.getSource() == entryList)
		{
			JComboBox<String> combo = (JComboBox<String>) event.getSource();
			entryType = (String) combo.getSelectedItem();
			System.out.println(combo.getSelectedItem() + " is selected");
		}
		
		outputArea.setText(message);
		blankDisplay();
	}
	
	public String addEntry()
	{
		String message;
		String n = name.getText();
		
		//CycleEntry
		String terr = terrain.getText();
		String tem = tempo.getText();
		
		//SwimEntry
		String wh = where.getText();
		
		//Validation for empty string variables
		if(n.isEmpty()) //Name empty
		{
			return "Please enter a name";
		}
		else if (entryType.equals("Cycle"))
		{
			if (terr.isEmpty()) //Terrain empty
			{
				return "Please enter a terrain or change entry type";
			}
			else if (tem.isEmpty()) //Tempo empty
			{
				return "Please enter a tempo or change entry type";
			}
		}
		else if (entryType.equals("Swim") && wh.isEmpty()) //Where/location empty
		{
			return "Please enter a tempo or change entry type";
		}
		
		//Standard init and dec.
		int m = 0; int d = 0; int y = 0; float km = 0; int h = 0; int mm = 0; int s = 0; int repe = 0; int reco = 0;
		
		try //Validation for non-int integer entry (Cycle)
		{
			m = Integer.parseInt(month.getText());
			d = Integer.parseInt(day.getText());
			y = Integer.parseInt(year.getText());
			km = java.lang.Float.parseFloat(dist.getText());
			h = Integer.parseInt(hours.getText());
			mm = Integer.parseInt(mins.getText());
			s = Integer.parseInt(secs.getText());
		}
		catch (NumberFormatException e)
		{
			return message = "Enter numbers where numbers should be.";
		}
		
		try //Validation for non-int integer entry (Sprint)
		{
			//SprintEntry
			repe = Integer.parseInt(repetitions.getText());
			reco = Integer.parseInt(recovery.getText());
		}
		catch (NumberFormatException e)
		{
			if (entryType.equals("Sprint"))
			{
				return message = "Enter numbers where numbers should be including repetitions and recovery time for a sprint entry.";
			}
		}
		
		Entry e;
		
		switch (entryType)
		{
			case "Cycle": //CycleEntry
				e = new CycleEntry(n, d, m, y, h, mm, s, km, terr, tem);
				break;
			case "Swim": //SwimEntry
				e = new SwimEntry(n, d, m, y, h, mm, s, km, wh);
				break;
			case "Sprint": //SprintEntry
				e = new SprintEntry(n, d, m, y, h, mm, s, km, repe, reco);
				break;
			default: //Standard entry (impossible...maybe)
				e = new Entry(n, d, m, y, h, mm, s, km);
				break;
		}
		
		System.out.println("Adding entry to the records");
		message = myAthletes.addEntry(e); //Validation for uniqueness of entry
		return message;
	}
	
	public String lookupEntry()
	{
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		return myAthletes.lookupEntry(d, m, y);
	}
	
	public String lookupAllEntry()
	{
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up records ...");
		return myAthletes.lookupAllEntry(d, m, y);
	}
	
	public void blankDisplay()
	{
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");
		
		//CycleEntry
		terrain.setText("");
		tempo.setText("");
		
		//SwimEntry
		where.setText("");
		
		//SprintEntry
		repetitions.setText("");
		recovery.setText("");
	}
	
	//Fills the input fields on the display for testing purposes only
	public void fillDisplay(Entry ent)
	{
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	}
	
	//Changes selected item in combo-box (For testing)
	public void setComboBox(String type)
	{
		entryList.setSelectedItem(type);
	}
}

