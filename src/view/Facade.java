package view;

import controllers.Sistema;

public class Facade {
	Sistema sistema;
	
	public Facade() {
		sistema = new Sistema();
	}
		
	public void adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra, double preco) {
		sistema.adicionaItemPorQtd(nome, categoria, quantidade, unidade, localDeCompra, preco);
	}
	
	public void adicionaItemPorQuilo(String nome, String categoria, String localDeCompra, double preco) {
		sistema.adicionaItemPorQuilo(nome, categoria, localDeCompra, preco);
	}
	
	public void adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		sistema.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	public void deletaItem(int id){
		sistema.deletaItem(id);
	}
	
	private String atualizaItem(int id,String atributo, String valor) {
		return sistema.atualizaItem(id, atributo, valor);
	}
	
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		sistema.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	public String getItem(Integer id) {
		return sistema.getItem(id);
	}
	
	public String pesquisaItens() {
		return sistema.pesquisaItens();
	}
	
	public String getItemPorCategoria(String categoria) {
		return sistema.getItemPorCategoria(categoria);
	}
	
	public String getItemPorMenorPreco() {
		return sistema.getItemPorMenorPreco();
	}
	
	public String getItemPorPesquisa(String p) {
		return sistema.getItemPorPesquisa(p);
	}
}
