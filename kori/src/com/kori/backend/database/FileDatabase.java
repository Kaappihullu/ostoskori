
package com.kori.backend.database;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

class FileDatabase extends Database {

	private static  Vector<FileDatabase> m_dbList = new Vector<FileDatabase>();
	
	private Vector<HashMap<String, String>> m_data = new Vector<HashMap<String,String>>();
	private String m_databaseFile = "";
	
	FileDatabase(String file){
		super();
		
		m_databaseFile = file;	
		parseDatabase();
	}
	
	void flushData() {
		try{
				
			FileWriter writer = new FileWriter(m_databaseFile);
			
			for(HashMap<String, String> entry : m_data){
				
				writer.write(entry.size());
				
				Object[] values = entry.values().toArray();
				Object[] names = entry.keySet().toArray();
				
				
				for(int i=0;i<entry.size();i++){
					
					writer.write(names[i].toString().length());
					writer.write(names[i].toString());
					
					writer.write(values[i].toString().length());
					writer.write(values[i].toString());
				}
				
			}
			writer.flush();
			writer.close();
		}catch(Exception e){
			
		}
		
	}
	
	private String readValue(FileReader reader) throws IOException{
		
		int length = reader.read();
		char[] data = new char[length];
		reader.read(data);
		return new String(data);
		
	}
	
	private void parseDatabase(){
		
		m_data.clear();
		
		try{
			FileReader reader = new FileReader(m_databaseFile);
			while(reader.ready()){
				
				int count = reader.read();
				HashMap<String, String> row = new HashMap<String, String>();
				
				for(int i = 0;i<count;i++){
					row.put(readValue(reader), readValue(reader));
				}
				m_data.add(row);
			}
			
			reader.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}
		
	static FileDatabase getFileDatabase(String file){
		
		for(FileDatabase database : m_dbList){
			if(database.m_databaseFile.equals(file)){
				return database;
			}
		}
		
		
		FileDatabase database = new FileDatabase(file);
		m_dbList.add(database);
	
		return database;
	}
	
	final class FileDataWriter implements Database.IWriter{
		
		FileDatabase m_database = null;
		int m_index = -1;
		
		HashMap<String, String> m_data = new HashMap<String, String>();
		
		FileDataWriter(FileDatabase database, int index){
			m_database = database;
			m_index = index;
			
			m_data = m_database.m_data.get(index);
			
		}
		
		FileDataWriter(FileDatabase database){
			m_database = database;
		}
		
		@Override
		public void Write(String name, Object value) {
			m_data.put(name, value.toString());
		}

		@Override
		public void flush(boolean realFlush) {
			
			if(m_index != -1){
				m_database.m_data.set(m_index, m_data);
			}else{
				m_database.m_data.add(m_data);
			}
			if(realFlush){
				m_database.flushData();
			}
		}
		
	}
	
	final class FileDataReader implements Database.IReader{
		
		HashMap<String, String> m_data;
		
		FileDataReader(HashMap<String, String> data){
			m_data = data;
		}
		
		@Override
		public Object getValue(String name) {
			// TODO Auto-generated method stub
			return m_data.get(name);
		}

		@Override
		public Object getValue(int index) {
			//diipadaa!!
			return m_data.values().toArray()[index];
		}

		@Override
		public int getLength() {
			return m_data.size();
		}
		
	}



	@Override
	public IReader getReader(int index) {
		return new FileDataReader(m_data.get(index));
	}

	@Override
	public int getSize() {
		return m_data.size();
	}
	
	@Override
	public IWriter getWriter(int index){
		return new FileDataWriter(this,index);
	}
	
	@Override
	public IWriter getWriter() {
		
		return new FileDataWriter(this);
	}
	
}
