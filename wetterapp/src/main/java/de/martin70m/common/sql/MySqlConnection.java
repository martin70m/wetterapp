package de.martin70m.common.sql;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnection {

	private static final String serverName = "mysql6.1blu.de";
	private static final String portNumber = "3306";
	private static final String dataBase = "db1414x685817";
	private static final String dbms = "mysql";
	private static final String localPropertiesFile = "/deployments/db.properties";
	private static final String localPropertiesFileUnix = "/deployments/db.properties";
	private static String password;
	private static String userName;

	public MySqlConnection() {
		if (MySqlConnection.password == null) {
			Properties properties = new Properties();
			BufferedInputStream stream;
			try {
				// try on Windows-Systems
				String path = System.getProperty("user.home") + localPropertiesFile;
				stream = new BufferedInputStream(new FileInputStream(path));
				try {
					properties.load(stream);
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				// if failed try on Unix-Systems
				try {
					String path = System.getProperty("user.home") + localPropertiesFileUnix;
					stream = new BufferedInputStream(new FileInputStream(localPropertiesFileUnix));
					try {
						properties.load(stream);
						stream.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			String user = properties.getProperty("db.user");
			String password = properties.getProperty("db.password");

			MySqlConnection.userName = user;
			MySqlConnection.password = password;

		}
	}

	public Connection getConnection() throws SQLException {

		Connection conn;
		Properties connectionProps = new Properties();
		connectionProps.put("user", MySqlConnection.userName);
		connectionProps.put("password", MySqlConnection.password);
		
		String connection = "jdbc:" + MySqlConnection.dbms + "://" + MySqlConnection.serverName + ":"
				+ MySqlConnection.portNumber + "/" + MySqlConnection.dataBase + "?serverTimezone=Europe/Berlin&useSSL=false";
		
		conn = DriverManager.getConnection(connection, connectionProps);

		System.out.println("Connected to database");
		return conn;
	}
}
