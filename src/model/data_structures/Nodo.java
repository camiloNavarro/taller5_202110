package model.data_structures;

public class Nodo <T>
{
	private T valor ;
	
	private Nodo<T> siguiente;
	
	public Nodo( T pValor) 
	{
		valor = pValor;
		siguiente = null;
	}
	
	public T darValor() 
	{
		return valor;
	}
	
	public Nodo<T> darSiguiente()
	{
		return siguiente;
	}
	
	public void cambiarValor( T nuevo) 
	{
		valor = nuevo;
	}
	
	public void cambiarSiguiente ( Nodo<T> element) 
	{
		siguiente = element;
	}
}
