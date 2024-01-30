package edu.clarivate.jdbcsteps.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindAllUser {

	public static void main(String[] args) {
		findAllUser();
	}

	public static void findAllUser() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/userinfo_clv4?user=root&password=root";
			connection = DriverManager.getConnection(dbUrl);
			String sqlQuery = "SELECT * FROM user";
			preparedStatement = connection.prepareStatement(sqlQuery);
			resultSet = preparedStatement.executeQuery();
			// Process the Result Display To User
			while (resultSet.next()) {
				int userID = resultSet.getInt("user_id");
				System.out.print("UserId = " + userID + "\t");
				String userName = resultSet.getString("user_name");
				System.out.print("UserName = " + userName + "\t");
				String userEmail = resultSet.getString("user_email");
				System.out.print("UserEmail = " + userEmail + "\t");
				String userPassword = resultSet.getString("user_password");
				System.out.print("UserPassword = " + userPassword + "\t");
				int userAge = resultSet.getInt("user_age");
				System.out.print("UserAge = " + userAge + "\t");
				System.out.println();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
