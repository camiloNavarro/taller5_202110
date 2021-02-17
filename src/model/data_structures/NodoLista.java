package model.data_structures;

public class NodoLista <T>
{
	private T info ;
	
	private NodoLista<T> next;
	
	public NodoLista( T pValor) 
	{
		info = pValor;
		next = null;
	}
	
	public T getInfo() 
	{
		return info;
	}
	
	public NodoLista<T> getNext()
	{
		return next;
	}
	
	public void changeInfo( T nuevaInfo) 
	{
		info = nuevaInfo;
	}
	
	public void setNext ( NodoLista<T> nodeNext) 
	{
		next = nodeNext;
	}
}
