package com.onlineexamconduction;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author -- TkGitcode
 */
public class User {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		int option;
		/*
		 * 1 --> UserLogin     2 --> Exit
		 */
		System.out.println("1 - > login\n2 - > Exit");
		try {
			option = scanner.nextInt(); //UserOption
			switch (option) {
			case 1:
				new Userlogin(); //Here I am Creating a New Object to the class
				break;
			case 2:
				System.err.println("Thank you for Visiting");
				System.exit(0);
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
