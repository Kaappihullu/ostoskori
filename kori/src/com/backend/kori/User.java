
package com.backend.kori;

import java.util.*;

import com.backend.kori.database.Database;


public class User {
	
	private Database.IReader m_reader;
	
	private static Vector<User> m_users = null;
	private static Database m_database;
	
	protected User(Database.IReader reader){
		m_reader = reader;
	}
	
	private static void init(){
		
		m_users = new Vector<User>();
		m_database = Database.getDatabase(AppValue.getValue("UserDatabase"));
		
		for(int i=0;i<m_database.getSize();i++){
			m_users.add(new User(m_database.getReader(i)));
		}
		
	}
	
	public static boolean createUser(String name, String passwd){
		
		if(authenticate(name, passwd) == null){
		
			Database.IWriter writer = m_database.getWriter();
		
			writer.Write("name", name);
			writer.Write("passwd", passwd);
			writer.flush(true);
			return true;
		}else{
			return false;
		}

	}
	
	public static User authenticate(String name, String password){
		
		if(m_users == null){
			init();
		}
		
		return null;
	}
	
}
