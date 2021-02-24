package model.data_structures;

public interface ILista <T extends Comparable<T>>
{
	public void addFirst(T elemento);
	
	public void addLast(T elemento);
	
	public void insertElement(T element, int pos);
	
	public T removeFirst( );
	
	public T removeLast( ) ;
	
	public T deleteElement( int pos) ;
	
	public T firstElement( );
	
	public T lastElement();
	
	public T getElement( int pos) ;
	
	public int size( ) ;
	
	public boolean isEmpty( ) ;
	
	public int isPresent (T element);
	
	public void exchange (int pos1, int pos2);
	
	public void changeInfo (int pos, T elem) ;
	
	/**
	* Crear una sublista de la lista original (this).
	* Los elementos se toman en el mismo orden como aparecen en la lista original (this).
	* @param n�mero de elementos que contendr� la sublista. Si el n�mero es superior al tama�o
	* original de la lista, se obtiene una copia de la lista original.
	* @return sublista creada con la misma representaci�n de la lista original (this).
	*/
	public ILista<T> sublista(int numElementos);

}
