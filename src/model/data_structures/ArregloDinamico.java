package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements ILista <T>{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable [max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void addFirst(T elemento)
	{
		//verificar!
		
		
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [] copia = elementos;
			elementos = (T[]) new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}
		
		T [] movido = elementos;
		elementos = (T[]) new Comparable [tamanoMax];
		for ( int i = 0; i < tamanoAct; i++)
		{
			elementos[i+1] = movido[i];
		} 
		elementos[0] = elemento;
		tamanoAct++;
	}
	
	public void addLast(T elemento)
	{
		//verificar!
		
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [] copia = elementos;
			elementos = (T[]) new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = elemento;
		tamanoAct++;
	}
	
	public void insertElement(T element, int pos)
	{
		//implementar
	}
	
	public T removeFirst( )
	{
		//implementar
	}
	
	public T removeLast( ) 
	{
		//implementar
	}
	
	public T deleteElement( int pos) 
	{
		//implementar
	}
	
	public T firstElement( )
	{
		//implementar
	}
	
	public T lastElement()
	{
		//implementar
	}
	
	public T getElement( int pos) 
	{
		//implementar
	}
	
	public int size( ) 
	{
		//implementar
	}
	
	public boolean isEmpty( ) 
	{
		//implementar
	}
	
	public int isPresent (T element)
	{
		//implementar
	}
	
	public void exchange (int pos1, int pos2)
	{
		//implementar
	}
	
	public void changeInfo (int pos, T elem) 
	{
		//implementar
	}
	
	
	//METODOS ANTIGUOS
	
	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [] copia = elementos;
			elementos = (T[]) new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	/**
	 * Retornar el numero de elementos maximo en el arreglo
	 * @return tamaño maximo del arreglo
	 */

	public int darCapacidad() {
		return tamanoMax;
	}

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return tamaño actual del arreglo
	 */

	public int darTamano() {
		return tamanoAct;
	}

	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */

	public T darElemento(int i) 
	{
		// TODO implementar
		return elementos [i];
	}

	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */

	public T buscar(T dato) 
	{
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		T elementoBuscado = null;
		boolean encontro = false;
		for (int i = 0; i < tamanoAct && !encontro; i++)
		{
			if (elementos [i].compareTo(dato)==0)
			{
				elementoBuscado = elementos [i];
				encontro = true;
			}
		}
		return elementoBuscado;
	}

	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param dato Objeto de eliminacion en el arreglo
	 * @return dato eliminado
	 */

	public T eliminar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		T datoEliminado = null;
		boolean encontro = false;
		for (int i = 0; i < tamanoAct && !encontro; i++)
		{
			if (dato.compareTo(elementos[i])==0)
			{
				datoEliminado = elementos [i];
				encontro = true;
				for (int j = i; j < tamanoAct - 1; j++)
				{
					elementos [j] = elementos [j+1];
				}
			}
		}
		return datoEliminado;
	}
	
	/**
	 * Invertir los datos del arreglo.
	 */
	public void invertir ()
	{
	  for (int i = 0; i < tamanoAct/2; i ++)
	  {
	     T cambio = elementos [i];
	     elementos [i] = elementos [tamanoAct -1 -i];
	     elementos [tamanoAct -1 -i] = cambio;
	  }

	}
}
