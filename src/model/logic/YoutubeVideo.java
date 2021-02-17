package model.logic;


public class YoutubeVideo  implements Comparable<YoutubeVideo>{
	
	private String id;
	
	private String trendingDate;
	
	private String title;
	
	public YoutubeVideo(String pId, String pTrendingDate, String pTitle)
	{
		id=pId;
		trendingDate=pTrendingDate;
		title= pTitle;
	}
	
	public String darId()
	{
		return id;
	}
	
	public String darFecha()
	{
		return trendingDate;
	}
	
	public String darTitulo()
	{
		return title;
	}

	public int compareTo(YoutubeVideo otro) 
	{
		return this.darFecha().compareTo(otro.darFecha()); 
	}
}
