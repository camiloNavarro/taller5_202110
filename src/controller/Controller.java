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
		
	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("Cargando en lista encadenada ");
				    long startTime = System.currentTimeMillis();
				    modelo.cargarVideosLista(); 
				    long endTime = System.currentTimeMillis();
				    long delta= endTime-startTime;
				    
				    
				    String firstTitle = modelo.darVideosLista().firstElement().darTitulo();
				    String lastTitle = modelo.darVideosLista().lastElement().darTitulo();
				    int size = modelo.darVideosLista().size();
				    
				    view.printMessage("El primer video es: "+ firstTitle);
				    view.printMessage("El ultimo video es: "+ lastTitle);
				    view.printMessage("Cantidad de videos: " + size);
				    view.printMessage("El tiempo de carga es de: "+delta);
					break;
					
				case 2:
					view.printMessage("Cargando en arreglo dinamico ");
				    long startTime2 = System.currentTimeMillis();
				    modelo.cargarVideosDinamico(); 
				    long endTime2 = System.currentTimeMillis();
				    long delta2= endTime2-startTime2;
				    
				    
				    String firstTitle2 = modelo.darVideosDinamico().firstElement().darTitulo();
				    String lastTitle2 = modelo.darVideosDinamico().lastElement().darTitulo();
				    int size2 = modelo.darVideosDinamico().size();
				    
				    view.printMessage("El primer video es: "+ firstTitle2);
				    view.printMessage("El ultimo video es: "+ lastTitle2);
				    view.printMessage("Cantidad de videos: " + size2);
				    view.printMessage("El tiempo de carga es de: "+delta2);
					break;

				case 3:
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
