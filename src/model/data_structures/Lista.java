package model.data_structures;

public class Lista <T extends Comparable<T>> implements ILista <T>
{
	private Nodo<T> primero;
	
	private Nodo<T> ultimo;
	
	public Lista()
	{
		primero=null;
		ultimo=null;
	}
	
    public void addFirst(T elemento) {
    	if(primero==null){
    		primero=(Nodo<T>) elemento;
    		ultimo=primero;
    	}
    	else{
    		Nodo<T> actual=(Nodo<T>) elemento;
    		((Nodo<T>) elemento).cambiarSiguiente(primero);
    		primero=actual;
    	}
    }
	
	public void addLast(T elemento){
		if(ultimo==null){
    		ultimo=(Nodo<T>) elemento;
    		primero=ultimo;
    	}
    	else{
    		Nodo<T> actual=(Nodo<T>) elemento;
    		ultimo.cambiarSiguiente(actual);
    		ultimo=actual;
    	}
	}
	
	public void insertElement(T element, int pos){
		Nodo<T> actual=primero;
		for(int i=0; i<pos; i++){
			if(i==pos-1){
				actual.cambiarSiguiente((Nodo<T>) element);
			}
			actual=actual.darSiguiente();
		}
	}
	
	public T removeFirst( ){
		Nodo<T> eliminado=primero;
		primero=primero.darSiguiente();
		return eliminado.darValor();
	}
	
	public T removeLast( ){
		Nodo<T> eliminado=ultimo;
		Nodo<T> actual=primero;
		while(actual.darSiguiente().darSiguiente()!=null)
		{
			actual=actual.darSiguiente();
		}
		ultimo=actual;
		actual.cambiarSiguiente(null);
		return eliminado.darValor();
	}
	
	public T deleteElement( int pos){
		Nodo<T> buscado=null;
		Nodo<T> actual=primero;
		int con=1;
		while(con<pos){
			actual=actual.darSiguiente();
			con++;
		}
		buscado=actual.darSiguiente();
		actual.cambiarSiguiente(buscado.darSiguiente());
		return buscado.darValor();
	}
	
	public T firstElement( ){
		return primero.darValor();
	}
	
	public T lastElement(){
		return ultimo.darValor();
	}
	
	public T getElement( int pos){
		Nodo<T> actual=primero;
		int con=1;
		while(con < pos){
			actual=actual.darSiguiente();
			con++;
		}
		return actual.darValor();
	}
	
	public int size( ){
		Nodo<T> actual=primero;
		int con=1;
		while(actual.darSiguiente()!=null){
			actual=actual.darSiguiente();
			con++;
		}
		return con;
	}
	
	public boolean isEmpty( ){
		if(primero==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int isPresent (T element){
		Nodo<T> actual=primero;
		int con=1;
		while(actual.darValor().compareTo(element)!=0){
			actual=actual.darSiguiente();
			con++;
		}
		return con;
	}
	
	public void exchange (int pos1, int pos2){
		Nodo<T> actual=primero;
		Nodo<T> n1=null;
		Nodo<T> n2=null;
		int con =1;
		while(con!=size()|| (n1!=null && n2!=null)){
			if(con==pos1){
				n1=actual;
				actual=actual.darSiguiente();
				con++;
			}
			else if(con==pos2){
				n2=actual;
				actual=actual.darSiguiente();
				con++;
			}
			else{
				actual=actual.darSiguiente();
				con++;
			}
		}
		T dato=n1.darValor();
		n1.cambiarValor(n2.darValor());
		n2.cambiarValor(dato);
	}
	
	public void changeInfo (int pos, T elem){
		Nodo<T> actual=primero;
		int con=1;
		while(con < pos){
			actual=actual.darSiguiente();
			con++;
		}
		actual.cambiarValor(elem);
	}


}
