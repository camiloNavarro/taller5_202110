package model.logic;

import java.sql.Date;

public class Video {
	
	private String id;
	
	private Date fecha;
	
	private String titulo;
	
	public Video(String i, Date f, String t){
		id=i;
		fecha=f;
		titulo=t;
	}
	
	public String darId()
	{
		return id;
	}
	
	public Date darFecha()
	{
		return fecha;
	}
	
	public String darTitulo()
	{
		return titulo;
	}
}
