package com.musicbuddy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultsArr {

	public static List<Results> getAllAlbums() {
		// connection to the database
		Connection con;

		try {
			con = DriverManager.getConnection("jdbc:sqlite:./chinook.db", "", "");

			// prepare a Statement object for SQL queries
			Statement stmt = con.createStatement();

			// get all columns from the table "Album"
			ResultSet rs = stmt.executeQuery("SELECT Title, Name FROM Albums JOIN Artists USING (ArtistId) LIMIT 100");
			// ArrayList
			ArrayList<Results> list = new ArrayList<Results>();
					
			
			// access each row in the table
			while (rs.next()) {
				Results newResult = new Results();
				newResult.setName(rs.getString("Name"));
				newResult.setTitle(rs.getString("Title"));
				list.add(newResult);
			}
			
			return list;

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
		
	}

}