package model.data_structures;

public class Lista <T extends Comparable<T>> implements ILista <T>
{
	private NodoLista<T> first;

	private NodoLista<T> last;

	private int size;

	public Lista()
	{
		first=null;
		last=null;
		size = 0;
	}

	public void addFirst(T element) 
	{
		NodoLista<T> nuevo =new NodoLista<T>(element);
		if(size() <= 0)
		{
			first=nuevo;
			last=nuevo;
			size++;
		}
		else
		{
			nuevo.setNext(first);
			first=nuevo;
			size++;
		}
	}

	public void addLast(T element)
	{
		NodoLista<T> nuevo =new NodoLista<T>(element);
		if(size() == 0)
		{
			first=nuevo;
			last=nuevo;
			size++;
		}
		else
		{
			last.setNext(nuevo);
			last = nuevo;
			size ++;
		}
	}

	public void insertElement(T element, int pos)
	{
		if(pos > 1)
		{
			NodoLista<T> actual = first;
			for(int i = 1; i < pos - 1; i++)
			{
				actual = actual.getNext();
			}
			NodoLista<T> nodoNuevo =  new NodoLista<T>(element);
			nodoNuevo.setNext(actual.getNext());
			actual.setNext(nodoNuevo);
			size++;
		}
		else if (pos == 1)
		{
			addFirst (element);
		}
	}

	public T removeFirst( )
	{
		if (size() > 1)
		{
			NodoLista<T> eliminado=first;
			first = first.getNext();
			size--;
			return eliminado.getInfo();
		}
		else if (size == 1)
		{
			NodoLista<T> eliminado=first;
			first = null;
			last = null;
			size--;
			return eliminado.getInfo();
		}
		else
		{
			return null;
		}

	}

	public T removeLast( )
	{
		if (size() > 0)
		{
			NodoLista<T> actual = first;
			if (actual.getNext()!= null)
			{
				for (int i = 1; i < size() - 1; i++)
				{
					actual = actual.getNext();
				}

				NodoLista<T> eliminado = actual.getNext();
				actual.setNext(null);
				last = actual;
				size--;
				return eliminado.getInfo();
			}
			else 
			{
				NodoLista<T> eliminado = first;
				first = null;
				last = null;
				size--;
				return eliminado.getInfo();
			}
		}
		else
		{
			return null;
		}
	}

	public T deleteElement( int pos)
	{
		if (size() > 0 && pos > 0)
		{
			if(pos > 1)
			{
				NodoLista<T> actual = first;

				for(int i = 1; i < pos - 1; i++)
				{
					actual = actual.getNext();
				}
				if (actual.getNext().getNext()!= null)
				{
					NodoLista<T> eliminado = actual.getNext();
					actual.setNext(actual.getNext().getNext());
					size--;
					return eliminado.getInfo();
				}
				else
				{
					NodoLista<T> eliminado = actual.getNext();
					actual.setNext(null);
					size--;
					return eliminado.getInfo();
				}
			}
			else
			{
				NodoLista<T> eliminado = first;
				removeFirst();
				return eliminado.getInfo();
			}
		}
		else
		{
			return null;
		}
	}

	public T firstElement( )
	{
		return first != null ? first.getInfo() : null;
	}

	public T lastElement()
	{
		return last != null ? last.getInfo() : null;
	}

	public T getElement( int pos)
	{
		if(size() > 0)
		{
			NodoLista <T> actual = first;
			for (int i = 1; i < pos; i++)
			{
				actual = actual.getNext();
			}
			return actual.getInfo();
		}
		else
		{
			return null;
		}
	}

	public int size( )
	{
		return size;
	}

	public boolean isEmpty( )
	{
		return size() == 0 ? true: false; 
	}

	public int isPresent (T element)
	{
		int posicion = -1;
		if(size() > 0)
		{
			NodoLista <T> actual = first;
			boolean encontro = false;
			for (int i = 1; i <= size() && encontro == false; i++)
			{
				if (actual.getInfo().compareTo(element) == 0)
				{
					posicion = i;
					encontro = true;
				}
				actual = actual.getNext();
			}
		}
		return posicion;
	}

	public void exchange (int pos1, int pos2)
	{
		if (pos1 <= size() && pos2 <= size())
		{
			T info1 = getElement(pos1);
			T info2 = getElement(pos2);

			changeInfo(pos1, info2);
			changeInfo(pos2, info1);
		}
	}

	public void changeInfo (int pos, T elem)
	{
		NodoLista<T> actual=first;
		for (int i = 1; i < pos; i++)
		{
			actual=actual.getNext();
		}
		actual.changeInfo(elem);
	}

	/**
	 * Crear una sublista de la lista original (this).
	 * Los elementos se toman en el mismo orden como aparecen en la lista original (this).
	 * @param número de elementos que contendrá la sublista. Si el número es superior al tamaño
	 * original de la lista, se obtiene una copia de la lista original.
	 * @return sublista creada con la misma representación de la lista original (this).
	 */
	public ILista<T> subLista(int numElementos)
	{
		ILista <T> subListaEncadenada = new Lista<T>();
		if (numElementos >= size())
		{
			numElementos = size();
		}

		for (int i = 1 ; i <= numElementos; i ++)
		{
			T actual = getElement(i);
			subListaEncadenada.addLast(actual);
		}

		return subListaEncadenada;
	}

	public ILista<T> subList(int posInicial, int posFinal)
	{
		ILista <T> subListEncadenada = new Lista<T>();
		if ((posFinal - posInicial + 1 ) >= size())
		{
			posInicial = 1;
			posFinal = size();
		}
		else
		{
			
			for (int i = posInicial ; i <= posFinal; i ++)
			{
				T actual = getElement(i);
				subListEncadenada.addLast(actual);
			}
			
		}
		
		return subListEncadenada;
	}
}
