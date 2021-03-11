package model.logic;

import java.util.Comparator;

public class Category implements Comparable<Category>{
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

	@Override
	public int compareTo(Category o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
