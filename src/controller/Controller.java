package controller;

import java.util.Scanner;

import model.data_structures.ILista;
import model.logic.Modelo;
import model.logic.YoutubeVideo;
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
					view.printMessage("Cargando en arreglo dinamico ");
					modelo.cargarVideosDinamico(); 
					modelo.cargarCategorias();
					int sizeDinamico = modelo.darVideosDinamico().size();
					view.printMessage("Cantidad de videos cargados en el arreglo dinamico: " + sizeDinamico);
					String infoPrimerCargado = modelo.getInfoFirst();
					view.printMessage("Informacion general del primer video cargado: \n" + infoPrimerCargado);
					view.printMessage("Lista de las categorias: ");
					for (int i = 1; i <= modelo.darCategoriasVideos().size(); i++)
					{
						String categoryID = modelo.darCategoriasVideos().getElement(i).getCategoryID();
						String categoryName = modelo.darCategoriasVideos().getElement(i).getCategoryName();

						view.printMessage(categoryID + "|||" + categoryName);
					}

					view.printMenuRequerimientos();
					int optionReq = lector.nextInt();
					switch (optionReq){
					case 1:
						view.printMessage("Sobre cual categoria desea aplicar el requerimiento?");
						String categoryNameR1 = lector.next();
						view.printMessage("Sobre cual pais desea aplicar el requerimiento?");
						String countryR1 = lector.next();
						view.printMessage("Cuantos videos con el mayor numero de reproducciones desea tener?");
						int numVideos = lector.nextInt();
						ILista<YoutubeVideo> subListaPaisCategoria = modelo.Req1(categoryNameR1, countryR1);
						view.printMessage("Los " +numVideos+ " videos tendencia en "+countryR1+ " con mas views de la categoria "+categoryNameR1+" son:");
						for (int i = 1; i <= numVideos; i++)
						{
							String title = subListaPaisCategoria.getElement(i).getTitle();
							String trendingDate = subListaPaisCategoria.getElement(i).getTrendingDate();
							String channelTitle = subListaPaisCategoria.getElement(i).getChannelTitle();
							String publishTime = subListaPaisCategoria.getElement(i).getPublishTime();
							int views = subListaPaisCategoria.getElement(i).getViews();
							int likes = subListaPaisCategoria.getElement(i).getLikes();
							int dislikes = subListaPaisCategoria.getElement(i).getDislikes();
							
							view.printMessage(title + "|||"+ trendingDate + "|||" + channelTitle + "|||"+ publishTime + "|||"+ views + "|||"+ likes + "|||"+ dislikes);
						}
						break;
					case 2:
						view.printMessage("Sobre cual pais desea aplicar el requerimiento?");
						String countryR2 = lector.next();
						String datosR2 = (modelo.Req2(countryR2));
						view.printMessage("El video con mas dias como tendencia en "+ countryR2 + " es:");
						view.printMessage(datosR2);
						break;
					case 3:
						view.printMessage("Sobre cual categoria desea aplicar el requerimiento?");
						String categoryNameR3 = lector.next();
						String datosR3 = (modelo.Req3(categoryNameR3));
						view.printMessage("El video con mas dias como tendencia segun la categoria "+ categoryNameR3 + " es:");
						view.printMessage(datosR3);
						break;
					case 4:
						
					case 5:
						fin = true;
						break;
					}
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
