package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Agent_bancaire;

public class Agent_bancaireDao {

	public boolean verifLogin(String email, String password) {
		// TODO Auto-generated method stub

		ObservableList<Agent_bancaire> lstPersonnel = FXCollections.observableArrayList();
		try {
			Connection connect = ConnectDB.initConnection();
			java.sql.Statement state = connect.createStatement();
			ResultSet result = state.executeQuery("SELECT userEmail, userMdp FROM personnel");
			while (result.next()) {
				if (result.getString("userEmail").equals(email) && result.getString("userMdp").equals(password)) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
