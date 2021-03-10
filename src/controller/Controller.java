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
					view.printMessage("Cargando en arreglo dinamico ");
					modelo.cargarVideosDinamico(); 
					int sizeDinamico = modelo.darVideosDinamico().size();
					view.printMessage("Cantidad de videos cargados en el arreglo dinamico: " + sizeDinamico);
					
			   case 2:
				   view.printMessage("las categorias son ");
				   modelo.cargarCategorias();
			}
		}	
	}	
}
