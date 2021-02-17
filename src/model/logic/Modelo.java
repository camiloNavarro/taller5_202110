package model.logic;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
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
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("video_id", "trending_date", "title").parse(in);
			for (CSVRecord record : records) 
			{
				String videoID = record.get("video_id");
				String trendingDate = record.get("trending_date");
				String title = record.get("title");
				YoutubeVideo nuevo=new YoutubeVideo(videoID, trendingDate, title);
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
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("video_id", "trending_date", "title").parse(in);
			for (CSVRecord record : records) 
			{
				String videoID = record.get("video_id");
				String trendingDate = record.get("trending_date");
				String title = record.get("title");
				YoutubeVideo nuevo=new YoutubeVideo(videoID, trendingDate, title);
				videosLista.addLast(nuevo);
			}
		}
		catch (Exception e)
		{

		}
	}
}
