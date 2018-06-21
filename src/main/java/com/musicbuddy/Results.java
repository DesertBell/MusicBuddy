package com.musicbuddy;

public class Results {
	
	private static  String Title;
	private static String Name;
	
	//Constructors
	public Results() {
		
	}
	
	public Results(String Title, String Name) {
		Results.Title = Title;
		Results.Name = Name;
	}
	//Setters and Getters
	public static String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Results.Title = title;
	}
	public static String getName() {
		return Name;
	}
	public void setName(String name) {
		Results.Name = name;
	}

}
