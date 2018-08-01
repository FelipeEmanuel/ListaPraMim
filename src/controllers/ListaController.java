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
import util.Check;
import util.CheckLista;
import util.exceptions;

public class ListaController {
	
	private HashMap<String,ListaDeCompras> listas;
	
	public ListaController() {
		listas = new HashMap<String,ListaDeCompras>();
	}
	
	public void adicionaCompraALista(String descritorLista, int quantidade, Item item) {
		listas.get(descritorLista).addItem(quantidade, item);
	}
	
	
	public String adicionaListaDeCompras(String descritorLista) {
		Check.checkDescritorListaCriacao(descritorLista);
		listas.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}
	
	public String pesquisaListaDeCompras(String descritorLista) {
		Check.checkDescritorListaPesquisa(descritorLista);
		if (!listas.containsKey(descritorLista))
			exceptions.listaDeComprasNaoExisteException();		
		return listas.get(descritorLista).toString();
	}
	
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		Check.checkIdPesquisa(id);;
		Check.checkDescritorListaPesquisa(descritorLista);
		for(Compra c: listas.get(descritorLista).getCompras()) {
			if(c.getItem().getId() == id)
				return listas.get(descritorLista).pesquisaCompraEmLista(id);
		}
		return exceptions.compraNãoEncontradaPesquisaException();
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
					exceptions.compraNãoEncontradaException();;
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
					exceptions.compraNãoEncontradaException();
				break;
				
			default:
				throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, double valorCompra) {
		Check.checkDescritorListaFinalizacao(descritorLista);
		Check.checkLocalDeCompraFinalizacao(localDeCompra);
		Check.checkValorCompra(valorCompra);
		listas.get(descritorLista).finalizarListaDeCompras(localDeCompra, valorCompra);
	}
	
	public String getItemLista(String descritorLista, int posicao) {
		return listas.get(descritorLista).getItemLista(posicao);
	}
	
	public void deletaCompraDeLista(String descritorLista, int id) {
		boolean maybe = true;
		Check.checkDescritorDeletaCompraDeLista(descritorLista);
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
	
	public ArrayList<ListaDeCompras> pesquisaListaPorData(String data) {
		Check.checkDataPesquisaListaPorData(data);
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
			exceptions.compraNãoEncontradaPesquisaException();
		lista.sort(new ComparadorLista());
		return lista;
	}
	
	public String geraAutomaticaUltimaLista() {
		ListaDeCompras l = autoLista();
		l.setDescricao("Lista automatica 1 "  + java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		listas.remove(l.getDescricao());
		listas.put(l.getDescricao(),l);
		return l.getDescricao();
	}	
	
	public ListaDeCompras autoLista() {
		String sx = "";
		long x = 0;
		for(String s : listas.keySet()) {
			if(listas.get(s).getHora()>x) {				
				x = listas.get(s).getHora();
				sx = s;
			}
		}
		return listas.get(sx);
	}

	public String geraAutomaticaItem(Item item) {
		ListaDeCompras l = autoListaItem(item.toStringCompra());
		l.setDescricao("Lista automatica 2 "  + java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		listas.put(l.getDescricao(),l);
		return l.getDescricao();
	}
	
	public ListaDeCompras autoListaItem(String item) {
		long x = 0;
		String sx = "";
		for(String s : listas.keySet()) {
			if(listas.get(s).toString().trim().toLowerCase().contains(item.trim().toLowerCase()) && listas.get(s).getHora()>=x-System.currentTimeMillis()) {				
				x = listas.get(s).getHora();
				sx = s;
			}
		}
		if(sx.equals(""))
			throw new IllegalArgumentException("Erro na geracao de lista automatica por item: nao ha compras cadastradas com o item desejado.");
		return listas.get(sx);
	}

	public HashMap<String, ListaDeCompras> getListas() {
		return listas;
	}
	
	public void addLista(ListaDeCompras l) {
		listas.put(l.getDescricao(), l);
	}

	public void setListas(HashMap<String, ListaDeCompras> listas) {
		this.listas = listas;
	}
	
}
