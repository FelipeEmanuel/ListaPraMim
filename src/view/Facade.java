package view;

import controllers.Sistema;

public class Facade {
	Sistema sistema;
	
	public Facade() {
		sistema = new Sistema();
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
        String[] itens = listaItens().split(System.lineSeparator());
        if (posicao < itens.length)
            return itens[posicao];
        return "";
    }

	public String getItemPorCategoria(String categoria, int posicao)
            throws NullPointerException, IllegalArgumentException {
        String[] itens = listaItens(categoria).split(System.lineSeparator());
        if (posicao < itens.length)
            return itens[posicao];
        return "";
	}

	public String getItemPorMenorPreco(int posicao) {
        String[] itens = listaItensPreco().split(System.lineSeparator());
        if (posicao < itens.length)
            return itens[posicao];
        return "";
    }

	public String getItemPorPesquisa(String strPesquisada, int posicao) {
        String[] itens = listaItensPesquisa(strPesquisada).split(System.lineSeparator());
        if (posicao < itens.length)
            return itens[posicao];
        return "";
    }
	
	/*
	 * US2
	 */
	
    public String listaItens() {
		// TODO Auto-generated method stub
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
    
	private String listaItensPesquisa(String strPesquisada) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
