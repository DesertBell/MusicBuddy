package com.musicbuddy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ResultsArr {

	public static void getAllAlbums() {
    		// connection to the database
            Connection con;

                try {
					con = DriverManager.getConnection("jdbc:sqlite:./chinook.db", "", "");
				
					// prepare a Statement object for SQL queries
					Statement stmt = con.createStatement(); 

					// get all columns from the table "Album"
					ResultSet rs = stmt.executeQuery("SELECT Title, Name FROM Albums JOIN Artists USING (ArtistId) LIMIT 100");

                	//ArrayList
					ArrayList<Results>list = new ArrayList<Results>();
					// variables for each column in the database
					String Title;
					String Name;

                // access each row in the table
					while (rs.next()) {
						for (int i = 0; i < list.size(); i++) {
						
							Title = rs.getString("Title");
							Name = rs.getString("Name");
						
						
						System.out.println(Title); 
						System.out.println(Name);

						
                }
						return;
					}
					
                } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}       
	
    }