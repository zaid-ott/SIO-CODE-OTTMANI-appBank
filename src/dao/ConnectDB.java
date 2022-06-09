package dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectDB {

	private static Connection connect = null;
	private String url = "jdbc:mysql://localhost/appbank";
	private String user = "zaid";
	private String passwd = "PhpMyAdmin_2022";

	public ConnectDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK !");
			connect = (Connection) DriverManager.getConnection(url, user, passwd);

			System.out.println("coonexion effective ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static java.sql.Connection initConnection() {
		if (connect == null) {
			new ConnectDB();
		}
		return connect;
	}

}
