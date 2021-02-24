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
				//Menu para escoger la representacion
				view.printMenuCarga();
				int optionCarga = lector.nextInt();
				switch (optionCarga) {
				case 1:
					view.printMessage("Cargando en lista enlazada ");
					modelo.cargarVideosLista();
					int sizeEnlazada = modelo.darVideosLista().size();
					view.printMessage("Cantidad de videos cargados en la lista enlazada: " + sizeEnlazada);
					//Menu para escoger si se realiza la muestra
					view.printMenuPostCarga();
					int optionMuestraEnlazada = lector.nextInt();
					switch (optionMuestraEnlazada) {
					case 1:
						view.printMessage("Digite el numero de elementos para la muestra");
						int numElementos = lector.nextInt();
						int sizeMuestraEnlazada = modelo.getsublistaEnlazada(numElementos).size();
						view.printMessage("Cantidad de videos en la muestra: " + sizeMuestraEnlazada);
						//Menu para escoger el ordenamiento deseado
						view.printMenuOrdenamiento();
						int optionOrdenamientoEnlazada = lector.nextInt();
						switch (optionOrdenamientoEnlazada){
						case 1:
							//InsertionEnlazada
						case 2:
							//ShellEnlazada
						case 3:
							//MergeEnlazada
						case 4:
							//QuickEnlazada
						case 5:
							view.printMessage("--------- \n Hasta pronto !! \n---------"); 
							lector.close();
							fin = true;
							break;
						}
					case 2:
						view.printMessage("--------- \n Hasta pronto !! \n---------"); 
						lector.close();
						fin = true;
						break;
					}

				case 2:
					view.printMessage("Cargando en arreglo dinamico ");
					modelo.cargarVideosDinamico(); 
					int sizeDinamico = modelo.darVideosDinamico().size();
					view.printMessage("Cantidad de videos cargados en el arreglo dinamico: " + sizeDinamico);
					//Menu para escoger si se realiza la muestra
					view.printMenuPostCarga();
					int optionMuestraDinamico = lector.nextInt();
					switch (optionMuestraDinamico) {
					case 1:
						view.printMessage("Digite el numero de elementos para la muestra");
						int numElementos = lector.nextInt();
						int sizeMuestraEnlazada = modelo.getsublistaDinamico(numElementos).size();
						view.printMessage("Cantidad de videos en la muestra: " + sizeMuestraEnlazada);
						//Menu para escoger el ordenamiento deseado
						view.printMenuOrdenamiento();
						int optionOrdenamientoDinamico = lector.nextInt();
						switch (optionOrdenamientoDinamico){
						case 1:
							//InsertionDinamico
						case 2:
							//ShellDinamico
						case 3:
							//MergeDinamico
						case 4:
							//QuickDinamico
						case 5:
							view.printMessage("--------- \n Hasta pronto !! \n---------"); 
							lector.close();
							fin = true;
							break;
						}
					case 2:
						view.printMessage("--------- \n Hasta pronto !! \n---------"); 
						lector.close();
						fin = true;
						break;
					}

				case 3:
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
				}

			case 2:
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;
			}
		}

	}	
}
