package view;

import controllers.Sistema;

public class Facade {
	Sistema sistema;
	
	public Facade() {
		sistema = new Sistema();
	}
	
	public void addProdutos(String nome, String categoria, String tipo) {
		sistema.addProdutos(nome, categoria, tipo);
	}
	
	public String pesquisaItem(Integer id) {
		return sistema.pesquisaItem(id);
	}
	
	public String pesquisaItens() {
		return sistema.pesquisaItens();
	}
	
	public String pesquisaCategorias(String categoria) {
		return sistema.pesquisaCategorias(categoria);
	}
	
	public String pesquisaPreço() {
		return sistema.pesquisaPreço();
	}
	
	public String pesquisa(String p) {
		return sistema.pesquisa(p);
	}
}
