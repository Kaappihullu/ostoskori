
package com.backend.kori;

import com.backend.kori.database.Database;

import java.util.*;
import java.security.*;

public class User {
	
	private Database.IReader m_reader;
	private Database.IWriter m_writer;
	
	private static Vector<User> m_users = null;
	private static Database m_database;
	private static int m_highId = 0;
	
	protected User(Database.IReader reader, Database.IWriter writer){
		m_reader = reader;
		m_writer = writer;
		
		int id = getId();
		
		if(id > m_highId){
			m_highId = id;
		}
		
	}
	
	private static int generateId(){
		return ++m_highId;
	}
	
	private static String generateAuthToken(String name, String passwd, String id){
		
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		
		return new String(md5.digest((name+"12"+passwd+"34"+id).getBytes()));
	}
	
	private static void init(){
		
		m_users = new Vector<User>();
		m_database = Database.getDatabase(AppValue.getValue("UserDatabase"));
		
		for(int i=0;i<m_database.getSize();i++){
			m_users.add(new User(m_database.getReader(i),m_database.getWriter(i)));
		}
		
	}
	
	public static boolean createUser(String name, String passwd){
		
		if(authenticate(name, passwd) == null){
		
			Database.IWriter writer = m_database.getWriter();
			String id = String.valueOf(generateId());
			
			writer.Write("id",id);
			writer.Write("name", name);
			writer.Write("passwd", generateAuthToken(name, passwd, id));
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
		
		for(User user : m_users){
			if(name.equals(user.getName())){
				if(generateAuthToken(name, password, String.valueOf(user.getId())).equals(user.getPasswdToken())){
					return user;
				}
			}
		}
		
		return null;
	}
	
	public int getId(){
		return Integer.valueOf(m_reader.getValue("id").toString());
	}
	
	public String getName(){
		return m_reader.getValue("name").toString();
	}
	
	public String getPasswdToken(){
		return m_reader.getValue("passwd").toString();
	}
	
	public int getBalance(){
		return Integer.valueOf(m_reader.getValue("balance").toString());
	}
	
	public void setBalance(int balance){
		m_writer.Write("balance", String.valueOf(balance));
		m_writer.flush(true);
	}
	
}
