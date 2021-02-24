package model.logic;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.Lista;

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

	public static String CSV_SMALL = "./data/videos-small.csv";


	public Modelo()
	{
		videosDinamico = new ArregloDinamico<YoutubeVideo>(7);
		videosLista = new Lista <YoutubeVideo>();
	}

	public ILista<YoutubeVideo> darVideosDinamico ()
	{
		return videosDinamico;
	}

	public ILista<YoutubeVideo> darVideosLista ()
	{
		return videosLista;
	}

	public void cargarVideosDinamico() 
	{
		try
		{
			Reader in = new FileReader(CSV_SMALL);
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

	public void cargarVideosLista()
	{
		try
		{
			Reader in = new FileReader(CSV_SMALL);
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
				videosLista.addLast(nuevo);
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	public ILista<YoutubeVideo> getsublistaEnlazada (int numElementos)
	{
		return videosLista.sublista(numElementos);
	}
	
	public ILista<YoutubeVideo> getsublistaDinamico (int numElementos)
	{
		return videosDinamico.sublista(numElementos);
	}
	
}
