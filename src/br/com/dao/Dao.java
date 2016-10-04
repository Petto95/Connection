package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.bean.Name;
import br.com.factory.Factory;

public class Dao {
	public void create(Name name){
		Connection con = Factory.getConnection();
		PreparedStatement ps = null;
		
		try{
			ps = con.prepareStatement("INSERT INTO tabela (nome) VALUE (?)");
			ps.setString(1, name.getName());
			ps.executeUpdate();
			System.out.println("File created");
		}
		catch(SQLException ex){
			System.out.println("Error of some kind");
		}
		finally{
			Factory.closeConnection(con, ps);
		}
	}
}
