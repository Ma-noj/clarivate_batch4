package edu.clarivate.jdbcsteps.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUserInfo {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the User Id :");
		int userId = read.nextInt();
		int numberOfRows = deleteUserById(userId);
		if (numberOfRows == 1) {
			System.out.println("User Info Removed");
		} else {
			System.out.println("User Info Not Removed");
		}
		read.close();
	}

	public static int deleteUserById(int userId) {
		int numberOfRows = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/userinfo_clv4?user=root&password=root";
			connection = DriverManager.getConnection(dbUrl);
			String sqlQuery = "DELETE FROM user WHERE user_id=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setInt(1, userId);

			numberOfRows = preparedStatement.executeUpdate();
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
		}
		return numberOfRows;
	}
}
