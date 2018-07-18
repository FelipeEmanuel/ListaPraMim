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
	
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return listas.get(descritorLista).pesquisaCompraEmLista(id);
	}
	
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int quantidade) {
		switch(operacao) {
			case	"adiciona":
				listas.get(descritorLista).addQuantidade(id, quantidade);
				break;
				
			case	"diminui":
				listas.get(descritorLista).diminuiQuantidade(id, quantidade);
				break;
		}
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, double valorCompra) {
		listas.get(descritorLista).finalizarListaDeCompras(localDeCompra, valorCompra);
	}
	
}
