package model.logic;

public class Category {
	private String category;
	private int id;
	
	public Category(String cat, int cId)
	{
		category=cat;
		id=cId;
	}
	
	public String darCategoria()
	{
		return category;
	}
	
	public int darId()
	{
		return id;
	}
}
