package controllers;

/**
* Classe responsável por controlar todos os itens presentes no sistema.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

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

	/**
	 * Construtor de ItemController.
	 */
	public ItemController() {
		itens = new HashMap<Integer, Item>();
	}
	
	/**
	 * Método responsável por adicionar itens com quantidade fixa a lista.
	 *  
	 * @param nome - Atributo do tipo String, nome do produto.
	 * @param categoria - Atributo do tipo String, categoria do produto.
	 * @param quantidade - Atributo do tipo Inteiro, quantidade de produtos a serem adicionados.
	 * @param unidade - Atributo do tipo String, que se refere a unidade de medida do produto.
	 * @param localDeCompra - Atributo do tipo String, que indica o estabelecimento em que o produto foi comprado.
	 * @param preco - Atributo do tipo Double, que indica o preço total do produto.
	 *
	 * @return Adiciona uma unidade e retorna o id do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra,double preco) {
		ValidaItem.validaQTD(nome, categoria, quantidade, unidade, localDeCompra, preco);
		ItemQI item = new ItemQI(nome, categoria, id, quantidade, unidade);
		if(itens.containsValue(item))
			exceptions.itemJaCadastrado();
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}

	/**
	 * Método responsável por adicionar itens não industrializados e por aquilo a lista.
	 * 
	 * @param nome - Atributo do tipo String, nome do produto.
	 * @param categoria - Atributo do tipo String, categoria do produto.
	 * @param kg - Atributo do tipo Double, preço por quilo.
	 * @param localDeCompra - Atributo do tipo String, que indica o estabelecimento onde foi realizado a compra.
	 * @param preco - Atributo do tipo Double, preço total do produto.
	 * 
	 * @return Adiciona uma unidade e retorna o id do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		ValidaItem.validaQuilo(nome, categoria, localDeCompra, preco, kg);
		ItemQuilo item = new ItemQuilo(nome, categoria, kg, id);
		if(itens.containsValue(item))
			exceptions.itemJaCadastrado();
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}
	
	/**
	 * Método responsável por adicionar itens por unidade a lista.
	 * 
	 * @param nome - Atributo do tipo String, nome do produto.
	 * @param categoria - Atributo do tipo String, categoria do produto.
	 * @param unidade - Atributo do tipo Inteiro, quantidade de unidades de cada produto.
	 * @param localDeCompra - Atributo do tipo String, que indica o estabelecimento onde foi realizado a compra.
	 * @param preco - Atributo do tipo Double, preço total do produto.
	 * 
	 * @return Adiciona uma unidade e retorna o id do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		ValidaItem.validaUnidade(nome, categoria, localDeCompra, preco, unidade);
		ItemUnidade item = new ItemUnidade(nome, categoria, id, unidade);
		if(itens.containsValue(item))
			exceptions.itemJaCadastrado();
		item.addPreco(localDeCompra, preco);
		itens.put(id, item);
		return id++;
	}
	
	/**
	 * Método responsável por exibir um item a partir de um id.
	 * 
	 * @param id - id do item.
	 * 
	 * @return - Exibe o item com um toString.
	 */
	public String exibeItem(int id) {
		Check.checkIdListagem(id);
		if(!itens.containsKey(id))
			exceptions.itemNaoExiste();
		return itens.get(id).toString();
	}

	/**
	 * Método responsável por deletar um item a partir de seu id.
	 * 
	 * @param id - id do item.
	 */
	public void deletaItem(int id) {
		if (itens.containsKey(id)) {
			itens.remove(id);
		} else {
			exceptions.itemNaoExiste();
		}
	}
	
	/**
	 * Método responsável por atualizar os valores de um item.
	 * 
	 * @param id - Id do item.
	 * @param atributo - Qual atributo do item será atualizado.
	 * @param valor - Valor que será atualizado.
	 */
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
	
	/**
	 * Método que se responsabiliza por mudar o preço do item de um estabelecimento.
	 * 
	 * @param id - id do item.
	 * @param localDeCompra - Estabelecimento onde o item foi comprado
	 * @param preco - Preço do item.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		
		Check.checkIdCadastroPreco(id);
		Check.checkLocalDeCompraCadastroPreco(localDeCompra);
		Check.checkPrecoCadastroPreco(preco);
		
		if (!itens.containsKey(id))
			exceptions.itemNaoExisteCadastroPreco();
		
		itens.get(id).addPreco(localDeCompra, preco);

	}
	
	/**
	 * Método que retorna o item pelo id que é listado por ordem alfabética.
	 * 
	 * @param id - id do item.
	 * 
	 * @return retorna o item especificado pelo id e seu toString.
	 */
	public String getItem(int id) {
		ArrayList l = listaItens();
		if(id< l.size())
			return l.get(id).toString();
		return"";
	}
	
	/**
	 * Método que ordena os itens de uma lista por ordem alfabética.
	 * 
	 * @return retorna a lista dos itens ordenada.
	 */
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
	
	/**
	 * Método que retorna um item que está listado em uma dada categoria.
	 * 
	 * @param categoria - categoria do produto.
	 * @param id - id do produto.
	 * 
	 * @return retorna um item e seu toString.
	 */
	public String getItemPorCategoria(String categoria, int id) {
		Check.checkCategoriaItemListagem(categoria);
		
		ArrayList l = listaItemPorCategoria(categoria);		
		
		if(id< l.size())
			return l.get(id).toString();
		
		return"";
	}
	
	/**
	 * Método que ordena os itens em ordem alfabética em uma determinada categoria.
	 * 
	 * @param categoria - categoria do item.
	 * 
	 * @return a lista de itens ordenada.
	 */
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
	
	/**
	 * Método que procura um item a partir de uma string de pesquisa.
	 * 
	 * @param p - String de pesquisa.
	 * @param id - id do item.
	 * 
	 * @return um item da dada pesquisa que possui o id em questão.
	 */
	public String getItemPorPesquisa(String p, int id) {
		ArrayList l = listaItemPorPesquisa(p);
		if(id< l.size())
			return l.get(id).toString();
		return"";
	}
	
	/**
	 * Método que ordena uma lista de itens que contem a String de pesquisa.
	 * 
	 * @param p - String de pesquisa.
	 * 
	 * @return Retorna uma lista de itens que possuem a String de pesquisa em seu toString.
	 */
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
	
	/**
	 * Método que retorna um item pelo id.
	 * 
	 * @param id - id do item
	 * 
	 * @return Retorna o item pelo seu id.
	 */
	public String getItemPorMenorPreco(int id) {
		ArrayList<Item> l = listaItemPorMenorPreco();
		if(id<l.size())
			return l.get(id).toString();
		return "";
	}
	
	/**
	 * Método que ordena os itens do menor preço até o maior.
	 * 
	 * @return retorna a lista de itens ordenada.
	 */
	public ArrayList listaItemPorMenorPreco() {
		ArrayList<Item> itens2 = new ArrayList<Item>();
		for (Item i : itens.values()) {
			if(i.getPrecos().size()>0)
				itens2.add(i);
		}
		itens2.sort(new ComparadorPreco());
		return itens2;
	}
	
	/**
	 * Método que verifica se o item está cadastrado.
	 * 
	 * @param id - id do item.
	 * 
	 * @return Retorno o item caso ele esteja cadastrado.
	 */
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
