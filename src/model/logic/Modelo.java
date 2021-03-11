package model.logic;

import java.io.FileReader;
import java.io.Reader;
import java.util.Comparator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.utils.Ordenamiento;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ILista <YoutubeVideo> videosDinamico;

	private ILista <YoutubeVideo> subListaVideosDinamico;

	private ILista <Category> categoriasVideos;

	public static String CSV_SMALL = "./data/videos-small.csv";
	public static String CSV_ALL = "./data/videos-all.csv";
	public static String CSV_CATEGORIES = "./data/category-id.csv";


	public Modelo()
	{
		videosDinamico = new ArregloDinamico<YoutubeVideo>(7);
		categoriasVideos = new ArregloDinamico<Category> (7);
		subListaVideosDinamico = null;
	}

	public ILista<YoutubeVideo> darVideosDinamico ()
	{
		return videosDinamico;
	}

	public ILista<YoutubeVideo> darsubListaVideosDinamico ()
	{
		return subListaVideosDinamico;
	}

	public ILista<Category> darCategoriasVideos ()
	{
		return categoriasVideos;
	}

	public String getInfoFirst()
	{
		YoutubeVideo firstVideo = videosDinamico.getElement(1);
		return firstVideo.getTitle() + "|||" + firstVideo.getChannelTitle() + "|||" + firstVideo.getTrendingDate() + "|||" + firstVideo.getCountry() + "|||" + firstVideo.getViews() + "|||" + firstVideo.getLikes() + "|||" + firstVideo.getDislikes();
	}

	public void cargarCategorias ()
	{
		try
		{
			Reader in = new FileReader(CSV_CATEGORIES);
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withTrim().withFirstRecordAsHeader().withDelimiter('\t').parse(in);
			for (CSVRecord record : records) 
			{
				String categoryID = record.get("id");
				String categoryName = record.get("name");
				categoryName = categoryName.trim();

				Category nuevaCategoria = new Category (categoryID, categoryName);
				darCategoriasVideos().addLast(nuevaCategoria);
			}
		}
		catch (Exception e)
		{

		}

	}

	public void cargarVideosDinamico() 
	{
		try
		{
			Reader in = new FileReader(CSV_ALL);
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) 
			{
				String videoID = record.get("video_id");
				String trendingDate = record.get("trending_date");
				String title = record.get("title");
				String channelTitle = record.get("channel_title");
				String categoryID = record.get("category_id");
				String publishTime = record.get("publish_time");
				String tags = record.get("tags");
				int views = Integer.parseInt(record.get("views"));
				int likes = Integer.parseInt(record.get("likes"));
				int dislikes = Integer.parseInt(record.get("dislikes"));
				int commentCount = Integer.parseInt(record.get("comment_count"));
				String thumbnailLink = record.get("thumbnail_link");
				String commentsDisabled = record.get("comments_disabled");
				String ratingsDisabled = record.get("ratings_disabled");
				String videoErrorOrRemoved = record.get("video_error_or_removed");
				String description = record.get("description");
				String country = record.get("country");

				YoutubeVideo nuevo=new YoutubeVideo(videoID, trendingDate, title,channelTitle,categoryID,publishTime,tags,views,likes,dislikes,commentCount,thumbnailLink,commentsDisabled,ratingsDisabled,videoErrorOrRemoved,description,country);
				darVideosDinamico().addLast(nuevo);
			}
		}
		catch (Exception e)
		{

		}
	}

	public Category getCategory (String categoryID)
	{
		Category buscada = null;
		for (int i = 1; i <= categoriasVideos.size(); i++)
		{
			Category actual = categoriasVideos.getElement(i);
			if(actual.getCategoryID().compareTo(categoryID) == 0)
			{
				buscada = actual;
			}
		}
		return buscada;
	}

	public void getSubListaDinamico (int numElementos)
	{
		subListaVideosDinamico = videosDinamico.subLista(numElementos);
	}

	public void ordenarLista (ILista <YoutubeVideo> lista,String tipoOrdenamiento, boolean ascendente)
	{
		Comparator<YoutubeVideo> comparadorXLikes = new YoutubeVideo.ComparadorXLikes();
		Ordenamiento<YoutubeVideo> algsOrdenamientoVideos = new Ordenamiento<YoutubeVideo>();

		if(tipoOrdenamiento.equalsIgnoreCase("Insertion"))
		{
			algsOrdenamientoVideos.ordenarInsercion(lista, comparadorXLikes, ascendente);
		}
		else if(tipoOrdenamiento.equalsIgnoreCase("Shell"))
		{
			algsOrdenamientoVideos.ordenarShell(lista, comparadorXLikes, ascendente);
		}
		else if(tipoOrdenamiento.equalsIgnoreCase("Merge"))
		{
			algsOrdenamientoVideos.ordenarMergeSort(lista, comparadorXLikes, ascendente);
		}
		else if(tipoOrdenamiento.equalsIgnoreCase("Quick"))
		{
			algsOrdenamientoVideos.ordenarQuickSort(lista, comparadorXLikes, ascendente);
		}
	}

	public void ordenarListaNombre (ILista <YoutubeVideo> lista, boolean ascendente)
	{
		Comparator<YoutubeVideo> comparadorXTitulo = new YoutubeVideo.ComparadorXTitulo();
		Ordenamiento<YoutubeVideo> algsOrdenamientoVideos = new Ordenamiento<YoutubeVideo>();

		algsOrdenamientoVideos.ordenarQuickSort(lista, comparadorXTitulo, ascendente);
	}
	
	public void ordenarListaLikes (ILista <YoutubeVideo> lista, boolean ascendente)
	{
		Comparator<YoutubeVideo> comparadorXLikes = new YoutubeVideo.ComparadorXLikes();
		Ordenamiento<YoutubeVideo> algsOrdenamientoVideos = new Ordenamiento<YoutubeVideo>();

		algsOrdenamientoVideos.ordenarQuickSort(lista, comparadorXLikes, ascendente);
	}

	public ILista<YoutubeVideo> Req1 (String categoryName, String country)
	{
		String categoryID = buscarCategoryID(categoryName);
		ILista<YoutubeVideo> subListaPaisCategoria = subListaPorPaisCategoria (darVideosDinamico(), categoryID, country);
		ordenarListaLikes (subListaPaisCategoria, false);
		
		return subListaPaisCategoria;
	}

	public String Req2 (String country)
	{
		ILista<YoutubeVideo> subListaPais = subListaPorPais (darVideosDinamico(), country);
		ordenarListaNombre(subListaPais, true);
		
		YoutubeVideo masRepetido = null;
		YoutubeVideo ultimoContado = null;
		int cuentaMaxima = 0;
		int ultimaCuenta = 0;
		for (int i = 1; i < subListaPais.size(); i++) 
		{
			YoutubeVideo actual = subListaPais.getElement(i);
			if(ultimoContado == null)
			{
				ultimaCuenta++;
			}
			else if (actual.getTitle().compareTo(ultimoContado.getTitle()) == 0) 
			{
				ultimaCuenta++;
			} 
			else if (ultimaCuenta > cuentaMaxima) 
			{
				cuentaMaxima = ultimaCuenta;
				masRepetido = ultimoContado;
			}
			ultimoContado = actual;
		}
		return masRepetido.getTitle() + "|||" + masRepetido.getChannelTitle() + "|||" + masRepetido.getCountry() + "|||" + cuentaMaxima;
	}

	public String Req3 (String categoryName)
	{
		String IDbuscado = buscarCategoryID(categoryName);
		ILista<YoutubeVideo> subListaCategoria = subListaPorCategoria (darVideosDinamico(), IDbuscado);

		ordenarListaNombre(subListaCategoria, true);

		YoutubeVideo masRepetido = null;
		YoutubeVideo ultimoContado = null;
		int cuentaMaxima = 0;
		int ultimaCuenta = 0;
		for (int i = 1; i <= subListaCategoria.size(); i++) 
		{
			YoutubeVideo actual = subListaCategoria.getElement(i);
			if(ultimoContado == null)
			{
				ultimaCuenta++;
			}
			else if (actual.getTitle().compareTo(ultimoContado.getTitle()) == 0) 
			{
				ultimaCuenta++;
			} 
			else if (ultimaCuenta > cuentaMaxima) 
			{
				cuentaMaxima = ultimaCuenta;
				masRepetido = ultimoContado;
			}
			ultimoContado = actual;
		}
		return masRepetido.getTitle() + "|||" + masRepetido.getChannelTitle() + "|||" + masRepetido.getCategoryID() + "|||" + cuentaMaxima; 
	}

	public String buscarCategoryID (String categoryName)
	{
		boolean buscado = false;
		String IDbuscado = "";
		for (int i = 1 ; i <= darCategoriasVideos().size() && !buscado; i++)
		{
			Category actual = darCategoriasVideos().getElement(i);
			if(actual.getCategoryName().equalsIgnoreCase(categoryName))
			{
				IDbuscado = actual.getCategoryID();
				buscado = true;
			}
		}

		return IDbuscado;
	}

	public ILista<YoutubeVideo> subListaPorPais (ILista<YoutubeVideo> lista, String country)
	{
		ILista <YoutubeVideo> subListaPais = new ArregloDinamico <YoutubeVideo>(1);

		for (int i = 1 ; i <= lista.size(); i ++)
		{
			YoutubeVideo actual = lista.getElement(i);
			if(actual.getCountry().compareTo(country) == 0)
			{
				subListaPais.addLast(actual);
			}

		}
		return subListaPais;
	}

	public ILista<YoutubeVideo> subListaPorCategoria (ILista<YoutubeVideo> lista, String categoryID)
	{
		ILista <YoutubeVideo> subListaCategoria = new ArregloDinamico <YoutubeVideo>(1);

		for (int i = 1 ; i <= lista.size(); i ++)
		{
			YoutubeVideo actual = lista.getElement(i);
			if(categoryID.compareTo("23") == 0 && (actual.getCategoryID().compareTo(categoryID)==0 || actual.getCategoryID().compareTo("34")==0) )
			{         
				subListaCategoria.addLast(actual);
			}
			else if(actual.getCategoryID().compareTo(categoryID)==0)
			{         
				subListaCategoria.addLast(actual);
			}

		}
		return subListaCategoria;
	}
	
	public ILista<YoutubeVideo> subListaPorPaisCategoria (ILista<YoutubeVideo> lista,String categoryID, String country )
	{
		ILista <YoutubeVideo> subListaPaisCategoria = new ArregloDinamico <YoutubeVideo>(1);

		for (int i = 1 ; i <= lista.size(); i ++)
		{
			YoutubeVideo actual = lista.getElement(i);
			if((categoryID.compareTo("23") == 0 && (actual.getCategoryID().compareTo(categoryID)==0 || actual.getCategoryID().compareTo("34")==0)) && (actual.getCountry().compareTo(country) == 0) )
			{         
				subListaPaisCategoria.addLast(actual);
			}
			else if((actual.getCategoryID().compareTo(categoryID)==0) && (actual.getCountry().compareTo(country) == 0))
			{         
				subListaPaisCategoria.addLast(actual);
			}

		}
		return subListaPaisCategoria;
	}

}
