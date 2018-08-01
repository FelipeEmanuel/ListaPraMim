package controllers;

/**
* Classe responsável por controlar as listas de compras presentes no sistema.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import comparators.ComparadorLista;
import comparators.ComparadorNome;
import entidades.Compra;
import entidades.Item;
import entidades.ListaDeCompras;
import util.Check;
import util.CheckLista;
import util.exceptions;

public class ListaController {
	
	private HashMap<String,ListaDeCompras> listas;
	
	/**
	 * Construtor de ListaController.
	 */
	public ListaController() {
		listas = new HashMap<String,ListaDeCompras>();
	}
	
	/**
	 * Método que adiciona produtos a lista.
	 * 
	 * @param descritorLista - Atributo descritor da lista, ou o nome da lista.
	 * @param quantidade - Quantidade do produto a ser adicionado na lista.
	 * @param item - Item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, Item item) {
		listas.get(descritorLista).addItem(quantidade, item);
	}
	
	/**
	 * Método que cria uma nova lista de compras.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * 
	 * @return Retorna o descritor da lista, ou o nome da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		Check.checkDescritorListaCriacao(descritorLista);
		listas.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}
	
	/**
	 * Método que pesquisa se a lista de compras existe.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * 
	 * @return Retorna a lista caso a mesma exista.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		Check.checkDescritorListaPesquisa(descritorLista);
		if (!listas.containsKey(descritorLista))
			exceptions.listaDeComprasNaoExisteException();		
		return listas.get(descritorLista).toString();
	}
	
	/**
	 * Método que pesquisa um item numa lista de compras a partir do seu id.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * @param id - id do item.
	 * 
	 * @return O item pesquisado, caso exista.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		Check.checkIdPesquisa(id);;
		Check.checkDescritorListaPesquisa(descritorLista);
		for(Compra c: listas.get(descritorLista).getCompras()) {
			if(c.getItem().getId() == id)
				return listas.get(descritorLista).pesquisaCompraEmLista(id);
		}
		return exceptions.compraNãoEncontradaPesquisaException();
	}
	
	/**
	 * Método que atualiza a quantidade de um item na lista de compra.
	 *  
	 * @param descritorLista - Descritor da lista, ou nome da lista.
	 * @param id - id do item.
	 * @param operacao - operação a se realizar no item.
	 * @param quantidade - quantidade a se modificar no item
	 */
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int quantidade) {
		boolean maybe = true;
		switch(operacao) {
			case	"adiciona":
				for(Compra c: listas.get(descritorLista).getCompras()) {
					if(c.getItem().getId() == id) {
						listas.get(descritorLista).addQuantidade(id, quantidade);
						maybe = false;
						break;
					}
				}
				if(maybe)
					exceptions.compraNãoEncontradaException();;
				break;
				
			case	"diminui":
				for(Compra c: listas.get(descritorLista).getCompras()) {
					if(c.getItem().getId() == id) {
						listas.get(descritorLista).diminuiQuantidade(id, quantidade);
						maybe = false;
						break;
					}
				}
				if(maybe)
					exceptions.compraNãoEncontradaException();
				break;
				
			default:
				throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
	}
	
	/**
	 * Método que finaliza a lista de compras.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * @param localDeCompra - Estabelecimento onde foi realizado a compra.
	 * @param valorCompra - valor total da lista de compras.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, double valorCompra) {
		Check.checkDescritorListaFinalizacao(descritorLista);
		Check.checkLocalDeCompraFinalizacao(localDeCompra);
		Check.checkValorCompra(valorCompra);
		listas.get(descritorLista).finalizarListaDeCompras(localDeCompra, valorCompra);
	}
	
	/**
	 * Método que retorna um item da lista a partir da sua posição na mesma.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * @param posicao - Posição do item na lista.
	 * 
	 * @return - Retorna o item da lista de uma dada posição.
	 */
	public String getItemLista(String descritorLista, int posicao) {
		return listas.get(descritorLista).getItemLista(posicao);
	}
	
	/**
	 * Método que remove uma compra da lista.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista. 
	 * @param id - id do item a ser deletado.
	 */
	public void deletaCompraDeLista(String descritorLista, int id) {
		boolean maybe = true;
		Check.checkDescritorDeletaCompraDeLista(descritorLista);
		for(Compra c: listas.get(descritorLista).getCompras()) {
			if(c.getItem().getId() == id) {
				listas.get(descritorLista).deletaCompraDeLista(id);
				maybe = false;
				break;
			}
		}
		if(maybe)
			throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");
	}
	
	/**
	 * Método que pesquisa uma lista de compras a partir da sua data.
	 * @param data - data da lista.
	 * @return - Retorna a lista pesquisada.
	 */
	public ArrayList<ListaDeCompras> pesquisaListaPorData(String data) {
		Check.checkDataPesquisaListaPorData(data);
		ArrayList<ListaDeCompras> listaData = new ArrayList<ListaDeCompras>();
		for(ListaDeCompras l : listas.values()) {
			if(data.equals(l.dataString()))
				listaData.add(l);
			}
		if (listaData.isEmpty() || listaData == null)
			throw new IllegalArgumentException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		listaData.sort(new ComparadorLista());
		return listaData;
	}
	
	/**
	 * Método que pesquisa uma lista de compras a partir do id de um item.
	 * 
	 * @param id - id de um item.
	 * 
	 * @return Retorna a lista pesquisada.
	 */
	public ArrayList<ListaDeCompras> pesquisaItemListaPorItem(int id) {
		ArrayList<ListaDeCompras> lista = new ArrayList<ListaDeCompras>();
		for(ListaDeCompras l : listas.values()) {
			for(Compra c: l.getCompras())
				if(c.getItem().getId() == id) {
					lista.add(l);
					break;
				}			
		}
		if(lista.isEmpty())
			exceptions.compraNãoEncontradaPesquisaException();
		lista.sort(new ComparadorLista());
		return lista;
	}
	
	/**
	 * Método que gera automáticamente a ultima lista criada.
	 * 
	 * @return Retorna uma lista de compras.
	 */
	public String geraAutomaticaUltimaLista() {
		ListaDeCompras l = new ListaDeCompras("Lista automatica 1 "  + java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		l.setCompras(autoLista().getCompras());
		listas.put(l.getDescricao(),l);
		return l.getDescricao();
	}	
	
	/**
	 * Método auxiliar para geraAutomaticaUltimaLista().
	 * 
	 * @return Retorna a lista para o método principal.
	 */
	public ListaDeCompras autoLista() {
		String sx = "";
		long x = 0;
		for(String s : listas.keySet()) {
			if(listas.get(s).getHora()>=x) {				
				x = listas.get(s).getHora();
				sx = s;
			}
		}
		return listas.get(sx);
	}
	
	/**
	 * Método que gera automáticamente a ultima lista em que o item pesquisado esteve presente.
	 * 
	 * @param item - Produto a ser pesquisado.
	 * 
	 * @return Retorna uma lista automática.
	 */
	public String geraAutomaticaItem(Item item) {
		ListaDeCompras l = new ListaDeCompras("Lista automatica 2 "  + java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		l.setCompras(autoListaItem(item.toString()).getCompras());
		listas.put(l.getDescricao(),l);
		return l.getDescricao();
	}
	/**
	 * Método auxiliar para o método geraAutomaticaItem().
	 * 
	 * @param item - Produto a ser pesquisado.
	 * 
	 * @return Retorna a string para o método principal.
	 */
	public ListaDeCompras autoListaItem(String item) {
		long x = 0;
		String sx = "";
		for(String s : listas.keySet()) {
			if(listas.get(s).toString().trim().toLowerCase().contains(item.trim().toLowerCase()) && listas.get(s).getHora()>=x) {				
				x = listas.get(s).getHora();
				sx = s;
			}
		}
		if(sx.equals(""))
			throw new IllegalArgumentException("Erro na geracao de lista automatica por item: nao ha compras cadastradas com o item desejado.");
		return listas.get(sx);
	}

	public HashMap<String, ListaDeCompras> getListas() {
		return listas;
	}
	
	/**
	 * Método que adiciona uma nova lista.
	 * 
	 * @param l - Uma lista de compras.
	 */
	public void addLista(ListaDeCompras l) {
		listas.put(l.getDescricao(), l);
	}

	public void setListas(HashMap<String, ListaDeCompras> listas) {
		this.listas = listas;
	}
	
}
