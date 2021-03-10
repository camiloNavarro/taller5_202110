package model.logic;

import java.io.FileReader;
import java.io.Reader;
import java.util.Comparator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.Lista;
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

	private ILista <YoutubeVideo> videosLista;
	
	private ILista <YoutubeVideo> subListaVideosDinamico;

	private ILista <YoutubeVideo> subListaVideosLista;
	
	private Category[] categoryLista;

	public static String CSV_SMALL = "./data/videos-small.csv";
	public static String CSV_ALL = "./data/videos-all.csv";
	public static String CATEGORY = "./data/category-id.csv";


	public Modelo()
	{
		videosDinamico = new ArregloDinamico<YoutubeVideo>(7);
		videosLista = new Lista <YoutubeVideo>();
		subListaVideosDinamico = null;
		subListaVideosLista = null;
		categoryLista = new Category[32];
	}

	public ILista<YoutubeVideo> darVideosDinamico ()
	{
		return videosDinamico;
	}

	public ILista<YoutubeVideo> darVideosLista ()
	{
		return videosLista;
	}
	
	public ILista<YoutubeVideo> darsubListaVideosDinamico ()
	{
		return subListaVideosDinamico;
	}

	public ILista<YoutubeVideo> darsubListaVideosLista ()
	{
		return subListaVideosLista;
	}
	
	public Category[] darsCategoriaLista ()
	{
		return categoryLista;
	}

	public void cargarVideosDinamico() 
	{
		try
		{
			Reader in = new FileReader(CSV_ALL);
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
			//Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("video_id", "trending_date", "title","channel_title","category_id","publish_time","tags","views","likes","dislikes","comment_count","thumbnail_link","comments_disabled","ratings_disabled","video_error_or_removed","description","country").parse(in);
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
				videosDinamico.addLast(nuevo);
			}
		}
		catch (Exception e)
		{

		}
	}

	public void cargarCategorias()
	{
		try
		{
			Reader in = new FileReader(CATEGORY);
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().withRecordSeparator('\t').parse(in);
			int i =0;
			//Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("video_id", "trending_date", "title","channel_title","category_id","publish_time","tags","views","likes","dislikes","comment_count","thumbnail_link","comments_disabled","ratings_disabled","video_error_or_removed","description","country").parse(in);
			for (CSVRecord record : records) 
			{
				int id = Integer.parseInt(record.get("id"));
				
				String name = record.get("name");
				name = name.trim();
				System.out.println(name);
				Category nuevo=new Category(name, id);
				
				categoryLista[i]=nuevo;
				i++;
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	public void getSubListaEnlazada (int numElementos)
	{
		subListaVideosLista = videosLista.subLista(numElementos);
	}
	
	public void getSubListaDinamico (int numElementos)
	{
		subListaVideosDinamico = videosDinamico.subLista(numElementos);
	}
	
	public void pruebaMuestraEnlazada()
	{
		ILista<YoutubeVideo> subListaVideos = videosLista.subLista(100000);
		Comparator<YoutubeVideo> comparadorXLikes = new YoutubeVideo.ComparadorXLikes();
		Ordenamiento<YoutubeVideo> algsOrdenamientoVideos = new Ordenamiento<YoutubeVideo>();
		algsOrdenamientoVideos.ordenarInsercion(subListaVideos, comparadorXLikes, true);
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
	
	public void requerimiento1(String pais, String categoria)
	{
		
	}
	
}
