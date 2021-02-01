package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
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
	private String elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = new String[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */

	public void agregar( String dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			String [ ] copia = elementos;
			elementos = new String[tamanoMax];
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

	public String darElemento(int i) 
	{
		// TODO implementar
		return elementos [i];
	}

	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */

	public String buscar(String dato) 
	{
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		String elementoBuscado = null;
		boolean encontro = false;
		for (int i = 0; i < tamanoAct && !encontro; i++)
		{
			if (dato.compareTo(elementos [i]) == 0)
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

	public String eliminar(String dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		String datoEliminado = null;
		boolean encontro = false;
		for (int i = 0; i < tamanoAct && !encontro; i++)
		{
			if (dato.compareTo(elementos [i]) == 0)
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
}
