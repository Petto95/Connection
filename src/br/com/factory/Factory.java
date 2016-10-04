package br.com.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Factory {
	
	static Connection con = null;
	final static String Driver="com.mysql.jdbc.Driver";
	final static String URL="jdbc:mysql://localhost:3306/teste";
	final static String USER="root";
	final static String PASSWORD="123";
	
	public static Connection getConnection(){
		try{
			Class.forName(Driver);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch(ClassNotFoundException|SQLException ex){
			throw new RuntimeException("Erro "+ex);
		}
		return con;
	}
	public static void closeConnection(Connection con){
		try{
			if(con!=null){
				con.close();
			}
		}
		catch(SQLException ex){
			System.out.println("Unable to close connection");
		}
	}
	public static void closeConnection(Connection con, PreparedStatement ps){
		closeConnection(con);
		try{
			if(ps!=null){
				ps.close();
			}
		}
		catch(SQLException ex){
			System.out.println("Unable to close connection + statement");
		}
	}
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
		}
		catch(SQLException ex){
			System.out.println("Error at override closeConnection(con,ps,rs)");
		}
	}
}