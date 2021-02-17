package model.logic;

import java.sql.Date;

public class Video  implements Comparable<Video>{
	
	private String id;
	
	private String fecha;
	
	private String titulo;
	
	public Video(String i, String f, String t){
		id=i;
		fecha=f;
		titulo=t;
	}
	
	public String darId()
	{
		return id;
	}
	
	public String darFecha()
	{
		return fecha;
	}
	
	public String darTitulo()
	{
		return titulo;
	}

	@Override
	public int compareTo(Video arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
