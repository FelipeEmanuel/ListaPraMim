package controllers;

import java.util.HashMap;

import entidades.Compra;
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
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		listas.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}
	
	public String pesquisaListaDeCompras(String descritorLista) {
		return listas.get(descritorLista).toString();
	}
	
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		if (id <= 0)
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		for(Compra c: listas.get(descritorLista).getCompras()) {
			if(c.getItem().getId() == id)
				return listas.get(descritorLista).pesquisaCompraEmLista(id);
		}
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}
	
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int quantidade) {
		boolean maybe = true;
		switch(operacao) {
			case	"adiciona":
				for(Compra c: listas.get(descritorLista).getCompras()) {
					if(c.getItem().getId() == id) {
						listas.get(descritorLista).addQuantidade(id, quantidade);
						maybe = false;
						break;
					}
				}
				if(maybe)
					throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
				break;
				
			case	"diminui":
				for(Compra c: listas.get(descritorLista).getCompras()) {
					if(c.getItem().getId() == id) {
						listas.get(descritorLista).diminuiQuantidade(id, quantidade);
						maybe = false;
						break;
					}
				}
				if(maybe)
					throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
				break;
				
			default:
				throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, double valorCompra) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		if (localDeCompra.trim().isEmpty() || localDeCompra == null)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		if (valorCompra <= 0)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: valor final da lista invalido.");
		listas.get(descritorLista).finalizarListaDeCompras(localDeCompra, valorCompra);
	}
	
	public String getItemLista(String descritorLista, int posicao) {
		return listas.get(descritorLista).getItemLista(posicao);
	}
	
	public void deletaCompraDeLista(String descritorLista, int id) {
		boolean maybe = true;
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		for(Compra c: listas.get(descritorLista).getCompras()) {
			if(c.getItem().getId() == id) {
				listas.get(descritorLista).deletaCompraDeLista(id);
				maybe = false;
			}
	}
		if(maybe)
			throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");
	}
		
}
