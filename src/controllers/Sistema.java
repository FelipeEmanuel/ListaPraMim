package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import comparators.ComparadorNome;
import entidades.Item;
import entidades.ItemQI;
import entidades.ItemQuilo;
import entidades.ItemUnidade;


public class Sistema {
	
	private HashMap<Integer, Item> itens;
	private int id=1;
	
	public Sistema() {
		itens = new HashMap<Integer, Item>();
	}
	
	public void addProdutos(String nome, String categoria, String tipo) {
		
	}
	
	public void adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade) {
		ItemQI item = new ItemQI(nome, categoria, id,quantidade,unidade);
		itens.put(id++,item);
	} 
	
	public void adicionaItemPorQuilo(String nome, String categoria) {
		ItemQuilo item = new ItemQuilo(nome, categoria, id);
		itens.put(id++,item);
	}
	
	public void adicionaItemPorUnidade(String nome, String categoria, int unidade) {
		ItemUnidade item = new ItemUnidade(nome, categoria, id, unidade);
		itens.put(id++,item);
	}
	
	public void removerProduto(int id){
		if(itens.containsKey(id)) {
			itens.remove(id);
		}
		else {
			throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		}
	}
	
	public void removerProduto(String nome, String categoria){
		for(int i =1; i<= itens.size();i++){
			if(itens.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) 
					&& itens.get(i).getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
				itens.remove(i);
			}
		}
		throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
	}

	
	private String atualizaItem(int id,String atributo, String valor) {
		if(!itens.containsKey(id))
			return "Erro na atualizacao de item: item nao existe.";
		switch(atributo)
		{
			case	"Nome":
				if(valor != null)
					itens.get(id).setNome(valor);
				else
					throw new IllegalArgumentException("Erro na atualizacao de item: Nome não pode ser nulo");
			case	"Categoria":
				if(valor != null)
					itens.get(id).setCategoria(valor);
				else
					throw new IllegalArgumentException("Erro na atualizacao de item: Categoria não pode ser nulo");
			case	 "ID":
				throw new IllegalArgumentException("Erro na atualizacao de item: ID não pode ser mudado");
		}
		return "Erro na atualizacao de item: Atributo inexistente";
	} 	
	
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		itens.get(id).addPreco(localDeCompra, preco);

	}
	
	public String pesquisaItem(Integer id) {
		return itens.get(id).toString();
	}
	
	public String pesquisaItens() {
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for(Item i : itens.values()){
			itens2.add(i);
		}
		itens2.sort(new ComparadorNome());
		retorno = itens2.toString();
		return retorno;
	}
	
	public String pesquisaCategorias(String categoria) {
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for(Item i : itens.values()){
			if(i.getCategoria().equals(categoria)) {
				itens2.add(i);
			}
		}
		itens2.sort(new ComparadorNome());
		retorno = itens.toString();
		return retorno;
	}
	
	public String pesquisaPreço() {
		
		return "";
	}

	public String pesquisa(String p) {
		String pesquisa = p.toLowerCase();
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for(Item i : itens.values()){
			if(i.toString().toLowerCase().contains(pesquisa))
				itens2.add(i);
		}
		retorno = itens2.toString();
		return retorno;
	}
	
}
