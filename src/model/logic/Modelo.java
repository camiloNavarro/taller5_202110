package model.logic;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico<String> datos;
	
	private Catalogo catalogo;
	
	public static String ARCHIVO_DETAILS = "./data/videos-small.csv";
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico<String>(7);
		catalogo = new Catalogo();
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico<String>(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param <T>
	 * @param dato
	 */
	public  void agregar(String dato)
	{	
		datos.agregar(dato);;
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}
	
	public void cargarDatos() throws Exception{
		Reader in = new FileReader(ARCHIVO_DETAILS);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		for (CSVRecord record : records) {
		    String wId = record.get("video_id");
		    String fecha = record.get("trending_date");
		    String titulo = record.get("title");
		    Video nuevo=new Video(wId, fecha, titulo);
		   catalogo.videos.agregar(nuevo);
		}
	}
	
	public Catalogo darCatalogo(){
		return catalogo;
	}
	
	public void invertirContenido ()
	{
		datos.invertir();
	}
	
	public String darElemento(int i)
	{
		return (String) datos.darElemento(i);
	}
}
