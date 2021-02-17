package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() throws Exception 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("cargar datos ");
				    long startTime = System.currentTimeMillis();
				    modelo.cargarDatos(); 
				    long endTime = System.currentTimeMillis();
				    long delta= endTime-startTime;
				    view.printMessage("el tiempo de carga es: "+delta);
				    String prim=modelo.darCatalogo().videos.darElemento(0).darTitulo();
				    int tam=modelo.darCatalogo().videos.darTamano();
				    String ult=modelo.darCatalogo().videos.darElemento(tam).darTitulo();
				    view.printMessage("el primer video es: "+prim);
				    view.printMessage("el ultimo video es: "+ult);
					break;

				case 2:
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
