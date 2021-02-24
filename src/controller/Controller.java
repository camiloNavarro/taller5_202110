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
						int numElementosEnlazada = lector.nextInt();
						modelo.getSubListaEnlazada(numElementosEnlazada);
						int sizeMuestraEnlazada = modelo.darsubListaVideosLista().size();
						view.printMessage("Cantidad de videos cargados en la muestra: " + sizeMuestraEnlazada);
						//Menu para escoger el ordenamiento deseado
						view.printMenuOrdenamiento();
						int optionOrdenamientoEnlazada = lector.nextInt();
						switch (optionOrdenamientoEnlazada){
						case 1:
							//InsertionEnlazada
							long startTimeIn = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosLista(),"Insertion", true);
							long stopTimeIn = System.currentTimeMillis(); 
							long elapsedTimeIn = stopTimeIn - startTimeIn;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeIn);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast = modelo.darsubListaVideosLista().size();
							for (int j = sizeLast - 9; j <= sizeLast; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
						case 2:
							//ShellEnlazada
							long startTimeSh = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosLista(),"Shell", true);
							long stopTimeSh = System.currentTimeMillis(); 
							long elapsedTimeSh = stopTimeSh - startTimeSh;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeSh);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast2 = modelo.darsubListaVideosLista().size();
							for (int j = sizeLast2 - 9; j <= sizeLast2; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
						case 3:
							//MergeEnlazada
							long startTimeMe = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosLista(),"Merge", true);
							long stopTimeMe = System.currentTimeMillis(); 
							long elapsedTimeMe = stopTimeMe - startTimeMe;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeMe);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast3 = modelo.darsubListaVideosLista().size();
							for (int j = sizeLast3 - 9; j <= sizeLast3; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
						case 4:
							//QuickEnlazada
							long startTimeQu = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosLista(),"Quick", true);
							long stopTimeQu = System.currentTimeMillis(); 
							long elapsedTimeQu = stopTimeQu - startTimeQu;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeQu);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast4 = modelo.darsubListaVideosLista().size();
							for (int j = sizeLast4 - 9; j <= sizeLast4; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosLista().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosLista().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
						case 5:
							break;
						}
					case 2:
						
					case 3:
						break;
					}
					break;

				case 2:
					view.printMessage("Cargando en arreglo dinamico ");
					modelo.cargarVideosDinamico(); 
					int sizeDinamico = modelo.darVideosDinamico().size();
					view.printMessage("Cantidad de videos cargados en el arreglo dinamico: " + sizeDinamico);
					//Menu para escoger si se realiza la muestra o una prueba
					view.printMenuPostCarga();
					int optionMuestraDinamico = lector.nextInt();
					switch (optionMuestraDinamico) {
					case 1:
						view.printMessage("Digite el numero de elementos para la muestra");
						int numElementos = lector.nextInt();
						modelo.getSubListaDinamico(numElementos);
						int sizeMuestraDinamico = modelo.darsubListaVideosDinamico().size();
						view.printMessage("Cantidad de videos en la muestra: " + sizeMuestraDinamico);
						//Menu para escoger el ordenamiento deseado
						view.printMenuOrdenamiento();
						int optionOrdenamientoDinamico = lector.nextInt();
						switch (optionOrdenamientoDinamico){
						case 1:
							//InsertionDinamico
							long startTimeIn = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosDinamico(),"Insertion", true);
							long stopTimeIn = System.currentTimeMillis(); 
							long elapsedTimeIn = stopTimeIn - startTimeIn;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeIn);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast = modelo.darsubListaVideosDinamico().size();
							for (int j = sizeLast - 9; j <= sizeLast; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
						case 2:
							//ShellDinamico
							long startTimeSh = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosDinamico(),"Shell", true);
							long stopTimeSh = System.currentTimeMillis(); 
							long elapsedTimeSh = stopTimeSh - startTimeSh;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeSh);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast2 = modelo.darsubListaVideosDinamico().size();
							for (int j = sizeLast2 - 9; j <= sizeLast2; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
						case 3:
							//MergeDinamico
							long startTimeMe = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosDinamico(),"Merge", true);
							long stopTimeMe = System.currentTimeMillis(); 
							long elapsedTimeMe = stopTimeMe - startTimeMe;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeMe);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast3 = modelo.darsubListaVideosDinamico().size();
							for (int j = sizeLast3 - 9; j <= sizeLast3; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
						case 4:
							//QuickDinamico
							long startTimeQu = System.currentTimeMillis(); 
							modelo.ordenarLista (modelo.darsubListaVideosDinamico(),"Quick", true);
							long stopTimeQu = System.currentTimeMillis(); 
							long elapsedTimeQu = stopTimeQu - startTimeQu;
							view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimeQu);
							
							view.printMessage("Primeros 10: ");
							for (int i = 1; i <= 10; i++)//primeros 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(i).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(i).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
							view.printMessage("Ultimos 10: ");
							int sizeLast4 = modelo.darsubListaVideosDinamico().size();
							for (int j = sizeLast4 - 9; j <= sizeLast4; j++)//ultimos 10
							{
								String titulo = modelo.darsubListaVideosDinamico().getElement(j).getTitle();
								int valorCriterio = modelo.darsubListaVideosDinamico().getElement(j).getLikes();
								view.printMessage(titulo + "--"+ valorCriterio);
							}
							
						case 5:
							break;
						}
					case 2:
						long startTimePr = System.currentTimeMillis(); 
						modelo.pruebaMuestraEnlazada();
						long stopTimePr = System.currentTimeMillis(); 
						long elapsedTimePr = stopTimePr - startTimePr;
						view.printMessage("Tiempo de ejecucion en ms: " + elapsedTimePr);
					case 3:
						break;
					}

				case 3:
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
