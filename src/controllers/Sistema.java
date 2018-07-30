package controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import comparators.ComparadorLista;
import comparators.ComparadorListaPrecoFinal;
import entidades.Compra;
import entidades.Item;
import entidades.ListaDeCompras;
import entidades.SerializeSistema;

public class Sistema {
	ItemController sistema;
	ListaController lista;
	public Sistema() {
		sistema = new ItemController();
		lista = new ListaController();
	}
	
	//US1
		
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra, double preco) {
		return sistema.adicionaItemPorQtd(nome, categoria, quantidade, unidade, localDeCompra, preco);
	}
	
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return sistema.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}
	
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return sistema.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	public String exibeItem(int id) {
		return sistema.exibeItem(id);
	}
	
	public void deletaItem(int id){
		sistema.deletaItem(id);
	}
	
	public void atualizaItem(int id,String atributo, String valor) {
		sistema.atualizaItem(id, atributo, valor);
	}
	
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		sistema.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	/*
	 * US - 2 Metodos para auxiliar testes.
	 */


	public String getItem(int posicao) {
		return sistema.getItem(posicao);
	}

	public String getItemPorCategoria(String categoria, int posicao) {
        return sistema.getItemPorCategoria(categoria, posicao);
	}

	public String getItemPorMenorPreco(int posicao) {
        return sistema.getItemPorMenorPreco(posicao);
    }

	public String getItemPorPesquisa(String strPesquisada, int posicao) {
        return sistema.getItemPorPesquisa(strPesquisada, posicao);
    }
	
	/*
	 * US2
	 */
	
    public String listaItens() {
		return null;
	}
    
    public String listaItens(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}
    
    public String listaItensPreco() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public String listaItensPesquisa(String strPesquisada) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * US3
	 */
	
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return lista.pesquisaCompraEmLista(descritorLista, id);
	}
	public String adicionaListaDeCompras(String descritorLista) {
		return lista.adicionaListaDeCompras(descritorLista);
	}
	
	public String pesquisaListaDeCompras(String descritorLista) {
		return lista.pesquisaListaDeCompras(descritorLista);
	}
	
	public void adicionaCompraALista(String descritorLista, int quantidade, int id) {
		lista.adicionaCompraALista(descritorLista, quantidade, sistema.itemToLista(id));
	}
	
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int quantidade) {
		lista.atualizaCompraDeLista(descritorLista, id, operacao, quantidade);
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, double valorCompra) {	
		lista.finalizarListaDeCompras(descritorLista, localDeCompra, valorCompra);
	}
	
	public String getItemLista(String descritorLista, int posicao) {
		return lista.getItemLista(descritorLista, posicao);
	}
	
	public void deletaCompraDeLista(String descritorLista, int id) {
		if(!sistema.getItens().containsKey(id))
			throw new IllegalArgumentException("Erro na exclusao de compra: item nao existe no sistema.");
		lista.deletaCompraDeLista(descritorLista, id);
	}
	
	/**
	 *  US4
	 */
	
	public String dataAtual() {
		String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date());
		return data;
	}
	
	public String getItemListaPorData(String data, int posicao) {
		ArrayList<ListaDeCompras> listaData = pesquisaListaDeComprasPorData(data);
		if(posicao >= listaData.size())
			throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		return listaData.get(posicao).getDescricao();
	}
	
	public ArrayList<ListaDeCompras> pesquisaListaDeComprasPorData(String data) {
		return lista.pesquisaListaPorData(data);
	}
	
	public String getItemListaPorItem(int id, int posicao) {
		ArrayList<ListaDeCompras> lista = pesquisaListasDeComprasPorItem(id);
		return lista.get(posicao).dataString() + " - " + lista.get(posicao).getDescricao();
	}
	
	public ArrayList<ListaDeCompras> pesquisaListasDeComprasPorItem(int id) {
		return lista.pesquisaItemListaPorItem(id);
	}
	
	/**
	 * US5
	 */
	
	public String geraAutomaticaUltimaLista() {
		return lista.geraAutomaticaUltimaLista();
	}
	
	public String geraAutomaticaItem(String descritorItem) {
		int ix = 1;
		for(Item i : sistema.getItens().values()) {
			if(i.getNome().equals(descritorItem)) {
				ix = i.getId();
				break;
			}
		}
		return lista.geraAutomaticaItem(sistema.getItens().get(ix));
	}
	
	public String geraAutomaticaItensMaisPresentes() {
		ListaDeCompras list = new ListaDeCompras(null);
		for(Item i: sistema.getItens().values()) {
			int cont = 0;
			int quantidades = 0;
			for(ListaDeCompras l : lista.getListas().values()) {
				if(l.listaItens().contains(i)) {
					cont++;
					quantidades+= l.pesquisaItemCompraEmLista(i.getId()).getQuantidade();
				}
			};
			if(cont>= (lista.getListas().size()/2)) {
				list.addItem((int)Math.floor(quantidades/cont), i);
			}
		}
		list.setDescricao("Lista automatica 3 "  + java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		lista.addLista(list);
		return list.getDescricao();
	}
	
	/*
	 * US6
	 */
	
	public String sugereMelhorEstabelecimento(String descritorLista, int posEstabelecimento, int posLista){
		ArrayList<ListaDeCompras> list = pesquisaPrecoEstabelecimento(lista.getListas().get(descritorLista));
		if(list.size() == 0) {
			throw new IllegalArgumentException("Faltam dados para informar sobre preços em locais de compras.");
		}
		if(posLista == 0) {
			String s = String.format("%.2f",list.get(posEstabelecimento).getValorCompra()).replace(".",",");
			return list.get(posEstabelecimento).getDescricao() + ": R$ " + (String) s;
		}
		if(posLista-1 >= list.get(posEstabelecimento).listaItens().size())
			return "";
		return list.get(posEstabelecimento).itemString(list.get(posEstabelecimento).listaItens().get(posLista-1));
									
	}
	
	public ArrayList<ListaDeCompras> pesquisaPrecoEstabelecimento(ListaDeCompras l){
		HashMap<String, ListaDeCompras> list = new HashMap<String, ListaDeCompras>();
		for(Compra c: l.getCompras()) {
			for(Item i : sistema.getItens().values()) {
				if(c.getItem().equals(i)) {
					for(String s: i.getPrecos().keySet()) {
						if(list.containsKey(s)) {
							list.get(s).addItem(c.getQuantidade(), i);
						}else {
							list.put(s, new ListaDeCompras(s));
							list.get(s).addItem(c.getQuantidade(), i);
						}
					}
					break;
				}
			}
		}
		ArrayList<ListaDeCompras> lista2 = new  ArrayList<ListaDeCompras>();
		for(ListaDeCompras lx: list.values()) {
			double valor = 0;
			for(Compra c: lx.getCompras()) {
				for(String s : c.getItem().getPrecos().keySet()) {
					if(lx.getDescricao().equals(s))
						valor+= c.getQuantidade() * c.getItem().getPrecos().get(s).doubleValue();
				}
			}
			lx.setValorCompra(valor);
			lista2.add(lx);
		}
		lista2.sort(new ComparadorListaPrecoFinal());
		
		return lista2;
	}
	
	/**
	 * US7
	 */
	
	public void iniciaSistema() {
		sistema.setItens(SerializeSistema.carregaItens());
		lista.setListas(SerializeSistema.carregaListas());
	}
	
	
	public void fechaSistema() {
		SerializeSistema.salvarItens(sistema.getItens());
		SerializeSistema.salvarListas(lista.getListas());
	}
	
	
}
