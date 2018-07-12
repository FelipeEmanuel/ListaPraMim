package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import entidades.Item;
import entidades.ItemQI;
import entidades.ItemQuilo;
import entidades.ItemUnidade;


public class Sistema {
	private static final Comparator<? super Item> Comparator = null;
	private HashMap<Integer, Item> itens;
	private int id=1;
	
	public Sistema() {
		itens = new HashMap<Integer, Item>();
	}
	
	public void addProdutos(String nome, String categoria, String tipo) {
		
		if (tipo.equals("quantidade fixa")){
			ItemQI item = new ItemQI(nome, categoria, id);
			itens.put(id++,item);
		}
		
		if (tipo.equals("por unidade")){
			ItemQuilo item = new ItemQuilo(nome, categoria, id);
			itens.put(id++,item);
		}
		
		if (tipo.equals("por quilo")){
			ItemUnidade item = new ItemUnidade(nome, categoria, id);
			itens.put(id++,item);
		}
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
		//itens2.sort(Comparator);
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
		//itens2.sort(Comparator);
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
