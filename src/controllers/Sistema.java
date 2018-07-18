package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import comparators.ComparadorNome;
import comparators.ComparadorPreco;
import entidades.Item;
import entidades.ItemQI;
import entidades.ItemQuilo;
import entidades.ItemUnidade;
import entidades.ValidaItem;

public class Sistema {

	private HashMap<Integer, Item> itens;
	private int id = 1;

	public Sistema() {
		itens = new HashMap<Integer, Item>();
	}
	
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra,double preco) {
		ValidaItem.validaQTD(nome, categoria, quantidade, unidade, localDeCompra, preco);
		ItemQI item = new ItemQI(nome, categoria, id, quantidade, unidade);
		if(itens.containsValue(item))
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		ValidaItem.validaQuilo(nome, categoria, localDeCompra, preco, kg);
		ItemQuilo item = new ItemQuilo(nome, categoria, kg, id);
		if(itens.containsValue(item))
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		ValidaItem.validaUnidade(nome, categoria, localDeCompra, preco, unidade);
		ItemUnidade item = new ItemUnidade(nome, categoria, id, unidade);
		if(itens.containsValue(item))
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}
	

	public String exibeItem(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
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
		
		if	(atributo == null || atributo.isEmpty())
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		
		if	(valor == null || valor.isEmpty())
			throw new IllegalArgumentException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
		
		switch (atributo.toLowerCase()) {
		
		case "nome":
			itens.get(id).setNome(valor);
			break;
			
		case "categoria":
			if(!valor.toLowerCase().equals("alimento industrializado") 
					&& !valor.toLowerCase().equals("alimento nao industrializado")
					&& !valor.toLowerCase().equals("higiene pessoal")
					&& !valor.toLowerCase().equals("limpeza"))
				throw new Error("Erro na atualizacao de item: categoria nao existe.");
			itens.get(id).setCategoria(valor);
			break;
			
		case "unidade de medida":
			if(!itens.get(id).getClass().equals(new ItemQI("", "", 0, 0, "").getClass()))
				throw new IllegalArgumentException("Item não possui unidade de medida.");
			else {
				ItemQI i = (ItemQI) itens.get(id);				
				i.setUnidadeMedida(valor);
				itens.put(id, i);
			}
			break;
			
		case "quantidade":
			if(Double.parseDouble(valor) < 0)
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero.");
			if(!itens.get(id).getClass().equals(new ItemQI("", "", 0, 0, "").getClass()))
				throw new IllegalArgumentException("Item não possui unidade de medida.");
			else {
				ItemQI i = (ItemQI) itens.get(id);				
				i.setValorMedida(Integer.parseInt(valor));
				itens.put(id, i);
			}
			break;
			
		case "unidade":
			if(Double.parseDouble(valor) < 0)
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de unidade nao pode ser menor que zero.");
			if(!itens.get(id).getClass().equals(new ItemUnidade("", "", 0, 0).getClass()))
				throw new IllegalArgumentException("Item não possui unidade de medida.");
			else {
				ItemUnidade i = (ItemUnidade) itens.get(id);				
				i.setUnidade(Integer.parseInt(valor));
				itens.put(id, i);
			}
			break;
			
		case "kg":
			if(Double.parseDouble(valor) < 0)
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de quilos nao pode ser menor que zero.");
			if(!itens.get(id).getClass().equals(new ItemQuilo("", "", 0.0, 0).getClass()))
				throw new IllegalArgumentException("Item não possui unidade de medida.");
			else {
				ItemQuilo i = (ItemQuilo) itens.get(id);				
				i.setKg(Double.parseDouble(valor));
				itens.put(id, i);
			}
			break;
			
		case "ID":
			throw new IllegalArgumentException("Erro na atualizacao de item: ID não pode ser mudado.");
			
		default:
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
		}
	}
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if(id <= 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
		if(localDeCompra.isEmpty() || localDeCompra == null)
			throw new IllegalArgumentException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		if(preco <= 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
		if (!itens.containsKey(id))
			throw new IllegalArgumentException("Erro no cadastro de preco: item nao existe.");
		itens.get(id).addPreco(localDeCompra, preco);

	}

	public String getItem(int id) {
		ArrayList l = listaItens();
		if(id< l.size())
			return l.get(id).toString();
		return"";
	}

	public ArrayList listaItens() {
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for (Item i : itens.values()) {
			itens2.add(i);
		}
		itens2.sort(new ComparadorNome());
		retorno = itens2.toString();
		return itens2;
	}
	
	public String getItemPorCategoria(String categoria, int id) {
		if(!categoria.toLowerCase().equals("alimento industrializado") 
				&& !categoria.toLowerCase().equals("alimento nao industrializado")
				&& !categoria.toLowerCase().equals("higiene pessoal")
				&& !categoria.toLowerCase().equals("limpeza"))
			throw new Error("Erro na listagem de item: categoria nao existe.");
		ArrayList l = listaItemPorCategoria(categoria);		
		if(id< l.size())
			return l.get(id).toString();
		return"";
	}
	
	public ArrayList listaItemPorCategoria(String categoria) {
		ArrayList<Item> itens2 = new ArrayList();
		for (Item i : itens.values()) {
			if (i.getCategoria().equals(categoria)) {
				itens2.add(i);
			}
		}
		itens2.sort(new ComparadorNome());
		return itens2;
	}

	public String getItemPorPesquisa(String p, int id) {
		ArrayList l = listaItemPorPesquisa(p);
		if(id< l.size())
			return l.get(id).toString();
		return"";
	}
	
	public ArrayList listaItemPorPesquisa(String p) {
		String pesquisa = p.toLowerCase();
		String retorno = "";
		ArrayList<Item> itens2 = new ArrayList();
		for (Item i : itens.values()) {
			if (i.toString().toLowerCase().contains(pesquisa))
				itens2.add(i);
		}
		itens2.sort(new ComparadorNome());
		return itens2;
	}

	public String getItemPorMenorPreco(int id) {
		ArrayList<Item> l = listaItemPorMenorPreco();
		if(id<l.size())
			return l.get(id).toString();
		return "";
	}

	public ArrayList listaItemPorMenorPreco() {
		ArrayList<Item> itens2 = new ArrayList<Item>();
		for (Item i : itens.values()) {
			if(i.getPrecos().size()>0)
				itens2.add(i);
		}
		itens2.sort(new ComparadorPreco());
		return itens2;
	}

	public Item itemToLista(int id) {
		return itens.get(id);
	}
	
}
