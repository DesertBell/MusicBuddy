package com.musicbuddy;

public class Results {
	
	private String Title;
	private String Name;
	
	//Constructors
	public Results() {
		
	}
	
	public Results(String Title, String Name) {
		this.Title = Title;
		this.Name = Name;
	}
	//Setters and Getters
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}

}
