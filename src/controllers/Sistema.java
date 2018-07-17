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
	private int id = 1;

	public Sistema() {
		itens = new HashMap<Integer, Item>();
	}

	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra,
			double preco) {
		ItemQI item = new ItemQI(nome, categoria, id, quantidade, unidade);
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		ItemQuilo item = new ItemQuilo(nome, categoria, kg, id);
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		ItemUnidade item = new ItemUnidade(nome, categoria, id, unidade);
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}
	

	public String exibeItem(int id) {
		if(!itens.containsKey(id))
			throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");
		return itens.get(id).toString();
	}

	public void deletaItem(int id) {
		if (itens.containsKey(id)) {
			itens.remove(id);
		} else {
			throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");
		}
	}

	public void removerProduto(String nome, String categoria) {
		for (int i = 1; i <= itens.size(); i++) {
			if (itens.get(i).getNome().toLowerCase().equals(nome.toLowerCase())
					&& itens.get(i).getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
				itens.remove(i);
			}
		}
		throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
	}

	public void atualizaItem(int id, String atributo, String valor) {
		if (!itens.containsKey(id))
			throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		
		if	(atributo == null)
			throw new IllegalArgumentException("Erro na atualizacao de item: " + atributo + " nao pode ser nulo.");
		
		switch (atributo.toLowerCase()) {
		
		case "nome":
			itens.get(id).setNome(valor);
			break;
			
		case "categoria":
			itens.get(id).setCategoria(valor);
			break;
			
		case "unidade de medida":
			if(!itens.get(id).getClass().equals(new ItemQI("", "", 0, 0, "").getClass()))
				throw new IllegalArgumentException("Item não possui unidade de medida");
			else {
				ItemQI i = (ItemQI) itens.get(id);				
				i.setUnidadeMedida(valor);
				itens.put(id, i);
			}
			break;
			
		case "quantidade":
			if(!itens.get(id).getClass().equals(new ItemQI("", "", 0, 0, "").getClass()))
				throw new IllegalArgumentException("Item não possui unidade de medida");
			else {
				ItemQI i = (ItemQI) itens.get(id);				
				i.setValorMedida(Integer.parseInt(valor));
				itens.put(id, i);
			}
			break;
			
		case "kg":
			if(!itens.get(id).getClass().equals(new ItemQuilo("", "", 0.0, 0).getClass()))
				throw new IllegalArgumentException("Item não possui unidade de medida");
			else {
				ItemQuilo i = (ItemQuilo) itens.get(id);				
				i.setKg(Double.parseDouble(valor));
				itens.put(id, i);
			}
			break;
			
		case "ID":
			throw new IllegalArgumentException("Erro na atualizacao de item: ID não pode ser mudado");
			
		default:
			throw new IllegalArgumentException("Erro na atualizacao de item: Atributo inexistente");
		}
	}
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		itens.get(id).addPreco(localDeCompra, preco);

	}

	public String getItem(Integer id) {
		return itens.get(id).toString();
	}

	public String pesquisaItens() {
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for (Item i : itens.values()) {
			itens2.add(i);
		}
		itens2.sort(new ComparadorNome());
		retorno = itens2.toString();
		return retorno;
	}

	public String getItemPorCategoria(String categoria) {
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for (Item i : itens.values()) {
			if (i.getCategoria().equals(categoria)) {
				itens2.add(i);
			}
		}
		itens2.sort(new ComparadorNome());
		retorno = itens.toString();
		return retorno;
	}

	public String getItemPorMenorPreco() {

		return "";
	}

	public String getItemPorPesquisa(String p) {
		String pesquisa = p.toLowerCase();
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for (Item i : itens.values()) {
			if (i.toString().toLowerCase().contains(pesquisa))
				itens2.add(i);
		}
		retorno = itens2.toString();
		return retorno;
	}
}
