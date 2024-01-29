package edu.clarivate.jdbcsteps.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import edu.clarivate.jdbcsteps.dto.User;

public class UpdateUserInfo {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		User user = readUpdateUserInfo(read);
		int numberOfRows = modfiyUserInfo(user);
		if (numberOfRows == 1) {
			System.out.println("User Info Modified");
		} else {
			System.out.println("User Info Not Modified");
		}
	}

	public static int modfiyUserInfo(User user) {
		int numberOfRows = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/userinfo_clv4?user=root&password=root";
			connection = DriverManager.getConnection(dbUrl);
			String sqlQuery = "UPDATE user SET user_password=? WHERE user_id=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setInt(2, user.getUserId());
			preparedStatement.setString(1, user.getUserPassword());

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

	public static User readUpdateUserInfo(Scanner read) {
		User user = new User();
		System.out.println("Enter the User Id :");
		int userId = read.nextInt();
		System.out.println("Enter the User Password : ");
		String userPassword = read.next();

		user.setUserId(userId);
		user.setUserPassword(userPassword);
		return user;
	}
}
