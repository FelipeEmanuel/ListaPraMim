package view;

import java.text.DateFormat;
import java.util.Date;

import controllers.Sistema;

public class Facade {
	Sistema sistema = new Sistema();
	
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
		return sistema.pesquisaCompraEmLista(descritorLista, id);
	}
	public String adicionaListaDeCompras(String descritorLista) {
		return sistema.adicionaListaDeCompras(descritorLista);
	}
	
	public String pesquisaListaDeCompras(String descritorLista) {
		return sistema.pesquisaListaDeCompras(descritorLista);
	}
	
	public void adicionaCompraALista(String descritorLista, int quantidade, int id) {
		sistema.adicionaCompraALista(descritorLista, quantidade, id);
	}
	
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int quantidade) {
		sistema.atualizaCompraDeLista(descritorLista, id, operacao, quantidade);
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, double valorCompra) {	
		sistema.finalizarListaDeCompras(descritorLista, localDeCompra, valorCompra);
	}
	
	public String getItemLista(String descritorLista, int posicao) {
		return sistema.getItemLista(descritorLista, posicao);
	}
	
	public void deletaCompraDeLista(String descritorLista, int id) {
		sistema.deletaCompraDeLista(descritorLista, id);
	}
	
	/**
	 *  US4
	 */
	
	public String dataAtual() {
		return sistema.dataAtual();
	}
	public String getItemListaPorData(String data, int posicao) {
		return sistema.getItemListaPorData(data, posicao);
	}
	
	public String getItemListaPorItem(int id, int posicao) {
		return sistema.getItemListaPorItem(id, posicao);
	}
	
	public void pesquisaListasDeComprasPorData(String data) {
		sistema.pesquisaListaDeComprasPorData(data);
	}
	
	public void pesquisaListasDeComprasPorItem(int id) {
		sistema.pesquisaListasDeComprasPorItem(id);
	}
}
