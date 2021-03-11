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
	
	private ILista <Category> categorias;
	

	public static String CSV_SMALL = "./data/videos-small.csv";
	public static String CSV_ALL = "./data/videos-all.csv";
	public static String CATEGORY = "./data/category-id.csv";


	public Modelo()
	{
		videosDinamico = new ArregloDinamico<YoutubeVideo>(7);
		videosLista = new Lista <YoutubeVideo>();
		categorias = new Lista <Category>();
		subListaVideosDinamico = null;
		subListaVideosLista = null;
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
	
	public ILista<Category> darsCategoriaLista ()
	{
		return categorias;
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
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withTrim().withFirstRecordAsHeader().withDelimiter('\t').parse(in);
			//Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("video_id", "trending_date", "title","channel_title","category_id","publish_time","tags","views","likes","dislikes","comment_count","thumbnail_link","comments_disabled","ratings_disabled","video_error_or_removed","description","country").parse(in);
			for (CSVRecord record : records) 
			{
				int id = Integer.parseInt(record.get("id"));
				
				String name = record.get("name");
				name = name.trim();
				Category nuevo=new Category(name, id);
				
				categorias.addLast(nuevo);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
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
	
	public void ordenarViews(ILista <YoutubeVideo> lista,String tipoOrdenamiento, boolean ascendente)
	{
		Comparator<YoutubeVideo> comparadorXviews = new YoutubeVideo.ComparadorXViews();
		Ordenamiento<YoutubeVideo> algsOrdenamientoVideos = new Ordenamiento<YoutubeVideo>();
		algsOrdenamientoVideos.ordenarQuickSort(lista, comparadorXviews, ascendente);
	}
	
	public void requerimiento1(String pais, String categoria, int n)
	{
		ArregloDinamico<YoutubeVideo>paisV = new ArregloDinamico<YoutubeVideo>(7);
		for(int i=0;i<videosDinamico.size();i++)
		{
			if(videosDinamico.getElement(i).getCountry().equals(pais))
			{
				paisV.addLast(videosDinamico.getElement(i));
			}
		}
		int id=0;
		for(int j=0;j<categorias.size();j++)
		{
			if(categorias.getElement(j).darCategoria().compareToIgnoreCase(categoria)==0)
			{
				id=categorias.getElement(j).darId();
			}
		}
		ArregloDinamico<YoutubeVideo>paisC = new ArregloDinamico<YoutubeVideo>(7);
		for(int k=0; k<paisV.size();k++)
		{
			if(Integer.parseInt(paisV.getElement(k).getCategoryID())==id)
			{
				paisC.addLast(paisV.getElement(k));
			}
		}
		for(int l=0; l<n && n<paisC.size();l++)
		{
			YoutubeVideo actual=paisC.getElement(l);
			System.out.println("-------------------------------");
			System.out.println("titulo: " + actual.getTitle());
			System.out.println("trending date: " + actual.getTrendingDate());
			System.out.println("nombre del canal: " + actual.getChannelTitle());
			System.out.println("publish time: " + actual.getPublishTime());
			System.out.println("reproducciones: " + actual.getViews());
			System.out.println("likes: " + actual.getLikes());
			System.out.println("dislikes: " + actual.getDislikes());
		}
	}
	
	public void requerimiento4(String pais, String tag, int n)
	{
		ArregloDinamico<YoutubeVideo>paisV = new ArregloDinamico<YoutubeVideo>(7);
		for(int i=0;i<videosDinamico.size();i++)
		{
			if(videosDinamico.getElement(i).getCountry().equals(pais))
			{
				paisV.addLast(videosDinamico.getElement(i));
			}
		}
		ArregloDinamico<YoutubeVideo>paisT = new ArregloDinamico<YoutubeVideo>(7);
		for(int i=0; i<paisV.size();i++)
		{
			for(int j =0;j<paisV.getElement(i).darTags().length;j++)
			{
				if(paisV.getElement(i).darTags()[j].equals(tag))
				{
					paisT.addLast(paisV.getElement(i));
				}
			}
		}
		for(int i =0;i<n;i++)
		{
			System.out.println("-----------------------------------------" );
			System.out.println("titulo: " +paisV.getElement(i).getTitle());
			System.out.println("canal: " +paisV.getElement(i).getChannelTitle());
			System.out.println("publish time: " +paisV.getElement(i).getPublishTime());
			System.out.println("views: " +paisV.getElement(i).getViews());
			System.out.println("likes: " +paisV.getElement(i).getLikes());
			System.out.println("dislikes: " +paisV.getElement(i).getDislikes());
			System.out.println("tags: " +paisV.getElement(i).getTags());
		}
	}
	
}
