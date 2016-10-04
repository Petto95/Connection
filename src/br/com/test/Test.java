package br.com.test;

import br.com.bean.Name;
import br.com.dao.Dao;

public class Test {
	public static void main(String [] args){
		String name_sql = "Lilica";
		Name name = new Name();
		Dao dao = new Dao();
		
		name.setName(name_sql);
		dao.create(name);
	}
}
