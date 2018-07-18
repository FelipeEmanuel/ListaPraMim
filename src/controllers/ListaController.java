package controllers;

import java.util.HashMap;

import entidades.Item;
import entidades.ListaDeCompras;

public class ListaController {
	
	private HashMap<String,ListaDeCompras> listas;
	
	public ListaController() {
		listas = new HashMap<String,ListaDeCompras>();
	}
	
	public void adicionaCompraALista(String descritorLista, int quantidade, Item item) {
		listas.get(descritorLista).addItem(quantidade, item);
	}
	
	
	public String adicionaListaDeCompras(String descritorLista) {
		listas.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}
	
	public String pesquisaListaDeCompras(String descritorLista) {
		return listas.get(descritorLista).toString();
	}
	
}
