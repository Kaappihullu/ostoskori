package com.kori.backend.database;


public abstract class Database {
	
	public interface IReader {
		
		public Object getValue(String name);
		public Object getValue(int index);
		public int getLength();
		
	}
	
	public interface IWriter{
		public void Write(String name, Object value);
		//starts a new row.
		public void flush(boolean realFlush);
	}
	
	protected Database(){
		
	}
	
	public static Database getDatabase(String url){
		return FileDatabase.getFileDatabase(url);
	}
	
	
	public abstract IReader getReader(int index);
	public abstract int getSize();
	/*public abstract IReader getReader(String query);*/
	
	public abstract IWriter getWriter();
	public abstract IWriter getWriter(int index);
	
}
