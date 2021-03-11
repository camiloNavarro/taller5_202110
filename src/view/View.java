package view;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar archivo completo en una lista");
			System.out.println("2. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}
		
		public void printMenuCarga()
		{
			System.out.println("Escoja la representacion que desea");
			System.out.println("1. Arreglo dinamico");
			System.out.println("2. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}
		
		public void printMenuPostCarga()
		{
			System.out.println("Escoja lo que desea hacer con el arreglo ");
			System.out.println("1. Obtener una muestra de determinada cantidad de videos ");
			System.out.println("2. Hacer prueba completa con varias muestras de videos ");
			System.out.println("3. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}
		
		public void printMenuOrdenamiento()
		{
			System.out.println("Escoja el algoritmo de ordenamiento que desea aplicar");
			System.out.println("1. Insertion sort");
			System.out.println("2. Shell sort");
			System.out.println("3. Merge sort");
			System.out.println("4. Quick sort");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}
		
		public void printMenuRequerimientos()
		{
			System.out.println("Escoja el requerimiento que desea aplicar: ");
			System.out.println("1. Encontrar buenos videos por categoria y por pais");
			System.out.println("2. Encontrar video tendencia por pais");
			System.out.println("3. Encontrar video tendencia por categoria");
			System.out.println("4. Buscar los videos con mas likes");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) 
		{
			System.out.println(mensaje);
		}		
}
