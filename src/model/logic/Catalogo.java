package model.logic;

import model.data_structures.ArregloDinamico;

public class Catalogo {
	public ArregloDinamico<Video> videos;
	
	public Catalogo(){
		videos=new ArregloDinamico<Video>(10);
	}
}
