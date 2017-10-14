package com.capgemini.asset.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
		private static Connection con=null;
		public static Connection getConnection()
		{
			if(con==null)
			{
				Properties prop = new Properties();
				String url;
				String username;
				String password;
				String driver;
				try
				{
					FileInputStream fis=new FileInputStream("./resource/jdbc.properties");
					prop.load(fis);
					url=prop.getProperty("url");
					username=prop.getProperty("username");
					password=prop.getProperty("password");
					driver=prop.getProperty("driver");
					Class.forName(driver);
					con=DriverManager.getConnection(url,username,password);
					System.out.println("connected with DB...");
				}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				catch(SQLException e){
					e.printStackTrace();
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return con;
		}

	}