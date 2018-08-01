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
import util.Check;
import util.ValidaItem;
import util.exceptions;

public class ItemController {

	private HashMap<Integer, Item> itens;
	private int id = 1;

	public ItemController() {
		itens = new HashMap<Integer, Item>();
	}
	
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra,double preco) {
		ValidaItem.validaQTD(nome, categoria, quantidade, unidade, localDeCompra, preco);
		ItemQI item = new ItemQI(nome, categoria, id, quantidade, unidade);
		if(itens.containsValue(item))
			exceptions.itemJaCadastrado();
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		ValidaItem.validaQuilo(nome, categoria, localDeCompra, preco, kg);
		ItemQuilo item = new ItemQuilo(nome, categoria, kg, id);
		if(itens.containsValue(item))
			exceptions.itemJaCadastrado();
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		ValidaItem.validaUnidade(nome, categoria, localDeCompra, preco, unidade);
		ItemUnidade item = new ItemUnidade(nome, categoria, id, unidade);
		if(itens.containsValue(item))
			exceptions.itemJaCadastrado();
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}
	

	public String exibeItem(int id) {
		Check.checkIdListagem(id);
		if(!itens.containsKey(id))
			exceptions.itemNaoExiste();
		return itens.get(id).toString();
	}

	public void deletaItem(int id) {
		if (itens.containsKey(id)) {
			itens.remove(id);
		} else {
			exceptions.itemNaoExiste();
		}
	}

	public void removerProduto(String nome, String categoria) {
		for (int i = 1; i <= itens.size(); i++) {
			if (itens.get(i).getNome().toLowerCase().equals(nome.toLowerCase())
					&& itens.get(i).getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
				itens.remove(i);
			}
		}
		exceptions.itemNaoExisteAtualizacao();
	}

	public void atualizaItem(int id, String atributo, String valor) {
		if (!itens.containsKey(id))
			exceptions.itemNaoExisteAtualizacao();
		
		Check.checkAtributoAtualizacao(atributo);
		
		Check.checkValorAtualizacao(valor);
		
		switch (atributo.toLowerCase()) {
		
		case "nome":
			itens.get(id).setNome(valor);
			break;
			
		case "categoria":
			Check.checkValorAtualizacaoCategoria(valor);
			itens.get(id).setCategoria(valor);
			break;
			
		case "unidade de medida":
			if(!itens.get(id).getClass().equals(new ItemQI("", "", 0, 0, "").getClass()))
				exceptions.itemNaoPossuiUnidadeDeMedida();
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
				exceptions.itemNaoPossuiUnidadeDeMedida();
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
		
		Check.checkIdCadastroPreco(id);
		Check.checkLocalDeCompraCadastroPreco(localDeCompra);
		Check.checkPrecoCadastroPreco(preco);
		
		if (!itens.containsKey(id))
			exceptions.itemNaoExisteCadastroPreco();
		
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
		Check.checkCategoriaItemListagem(categoria);
		
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
	
		for (Item i : itens.values()) {
			if (i.getId() == id)
				return itens.get(id);	
		}
		
		exceptions.itemNaoExisteCompra();
		
		return null;
	
	}


	public HashMap<Integer, Item> getItens() {
		return itens;
	}


	public void setItens(HashMap<Integer, Item> itens) {
		this.itens = itens;
	}
	
}
