package com.onlineexamconduction;
/** 
* @Author -- TkGitcode
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Userlogin extends User{
	
	QuestionAnswer qa=new QuestionAnswer(); //Creating Object for QuestionAnswer(class)
	int flag=0;
	Userlogin() throws SQLException
	{
		
		Connection connection=DataBase.getConnection();
		PreparedStatement userPreparedStatement = connection.prepareStatement("insert into userlogindata_tbl(UserMailId,UserName) values(?,?)");
		System.out.println("Enter a Mail ID");
		String UseMailId=scanner.next();
		Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from userlogindata_tbl where UserMailId = '"+ UseMailId +"'");
        if(rs.next()) {
       		 System.out.println("Email is Already exixt ");
       		 getExam(UseMailId);
       		 flag=1;
        }
		if(flag==0)
		{
			System.out.println("Enter a User Name");
			String UserName=scanner.next();
			userPreparedStatement.setString(1, UseMailId); 
			userPreparedStatement.setString(2, UserName); 
			userPreparedStatement.execute();
		System.out.println("Successfully Logined");
		getExam(UseMailId);
		}
		
	}
	private void getExam(String useMailId) throws SQLException {
		Connection connection=DataBase.getConnection();
		System.out.println("You are Re Directed to Exam");
		qa.QuestionAnswerSession();
		int mark=qa.getScore();
		PreparedStatement MarkUpdatePreparedStatement = connection.prepareStatement("update userlogindata_tbl set UserMark = ? WHERE UserMailId= ?");
		MarkUpdatePreparedStatement.setInt(1, mark);
		MarkUpdatePreparedStatement.setString(2, useMailId);
		MarkUpdatePreparedStatement.executeUpdate();
		display(useMailId);
		}
	private void display(String useMailId) throws SQLException
	{
		Connection connection=DataBase.getConnection();
		Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from userlogindata_tbl where UserMailId = '"+ useMailId +"'");
        System.out.println("-----------------------------------------------------------");
        System.out.println("   "+ " Mail ID       " + "   " + "Name      " + "  " + " Total Score       ");
        System.out.println("-----------------------------------------------------------");
        while(rs.next()) {
       		 System.out.println("   "+ rs.getString(2) + "      " + rs.getString(3)+ "            " + rs.getString(4));
        } 
        System.out.println("-----------------------------------------------------------");
		
	}

}
