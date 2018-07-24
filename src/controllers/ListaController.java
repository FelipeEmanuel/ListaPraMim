package controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import comparators.ComparadorLista;
import comparators.ComparadorNome;
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
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		if (!listas.containsKey(descritorLista))
			throw new IllegalArgumentException("Erro na pesquisa de compra: lista de compras nao existe.");		
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
				break;
			}
		}
		if(maybe)
			throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");
	}
	
	public String getItemListaPorData(String data, int posicao) {
		ArrayList<ListaDeCompras> listaData = pesquisaListaPorData(data);
		if(posicao >= listaData.size())
			throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		return listaData.get(posicao).getDescricao();
	}
	public ArrayList<ListaDeCompras> pesquisaListaPorData(String data) {
		if (!data.equals(java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date())) && !(data.isEmpty() || data == null))
			throw new IllegalArgumentException("Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
		ArrayList<ListaDeCompras> listaData = new ArrayList<ListaDeCompras>();
		for(ListaDeCompras l : listas.values()) {
			if(data.equals(l.dataString()))
				listaData.add(l);
			}
		if (listaData.isEmpty() || listaData == null)
			throw new IllegalArgumentException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		listaData.sort(new ComparadorLista());
		return listaData;
	}
	
	public String getItemListaPorItem(int id, int posicao) {
		ArrayList<ListaDeCompras> lista = pesquisaItemListaPorItem(id);
		return lista.get(posicao).dataString() + " - " + lista.get(posicao).getDescricao();
	}
	
	public ArrayList<ListaDeCompras> pesquisaItemListaPorItem(int id) {
		ArrayList<ListaDeCompras> lista = new ArrayList<ListaDeCompras>();
		for(ListaDeCompras l : listas.values()) {
			for(Compra c: l.getCompras())
				if(c.getItem().getId() == id) {
					lista.add(l);
					break;
				}			
		}
		if(lista.isEmpty())
			throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		lista.sort(new ComparadorLista());
		return lista;
	}
	
	
		
}
