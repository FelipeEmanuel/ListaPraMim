package controllers;

/**
* Sistema principal do programa.
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
import java.util.Date;
import java.util.HashMap;

import comparators.ComparadorLista;
import comparators.ComparadorListaPrecoFinal;
import entidades.Compra;
import entidades.Item;
import entidades.ListaDeCompras;
import persistencia.SerializeSistema;

public class Sistema {
	ItemController itemController;
	ListaController listaController;
	
	/**
	 * Método construtor de Sistema.
	 */
	public Sistema() {
		itemController = new ItemController();
		listaController = new ListaController();
	}
	
	/*
	 * US1
	 */
	
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
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra, double preco) {
		return itemController.adicionaItemPorQtd(nome, categoria, quantidade, unidade, localDeCompra, preco);
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
		return itemController.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
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
		return itemController.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	/**
	 * Método responsável por exibir um item a partir de um id.
	 * 
	 * @param id - id do item.
	 * 
	 * @return - Exibe o item com um toString.
	 */
	public String exibeItem(int id) {
		return itemController.exibeItem(id);
	}
	
	/**
	 * Método responsável por deletar um item a partir de seu id.
	 * 
	 * @param id - id do item.
	 */
	public void deletaItem(int id){
		itemController.deletaItem(id);
	}
	
	/**
	 * Método responsável por atualizar os valores de um item.
	 * 
	 * @param id - Id do item.
	 * @param atributo - Qual atributo do item será atualizado.
	 * @param valor - Valor que será atualizado.
	 */
	public void atualizaItem(int id,String atributo, String valor) {
		itemController.atualizaItem(id, atributo, valor);
	}
	
	/**
	 * Método que se responsabiliza por mudar o preço do item de um estabelecimento.
	 * 
	 * @param id - id do item.
	 * @param localDeCompra - Estabelecimento onde o item foi comprado
	 * @param preco - Preço do item.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		itemController.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	/*
	 * US - 2 Metodos para auxiliar testes.
	 */

	/**
	 * Método que retorna o item pelo id que é listado por ordem alfabética.
	 * 
	 * @param id - id do item.
	 * 
	 * @return retorna o item especificado pelo id e seu toString.
	 */
	public String getItem(int posicao) {
		return itemController.getItem(posicao);
	}
	
	/**
	 * Método que retorna um item que está listado em uma dada categoria.
	 * 
	 * @param categoria - categoria do produto.
	 * @param id - id do produto.
	 * 
	 * @return retorna um item e seu toString.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
        return itemController.getItemPorCategoria(categoria, posicao);
	}
	
	/**
	 * Método que retorna um item pelo id.
	 * 
	 * @param id - id do item
	 * 
	 * @return Retorna o item pelo seu id.
	 */
	public String getItemPorMenorPreco(int posicao) {
        return itemController.getItemPorMenorPreco(posicao);
    }
	
	/**
	 * Método que procura um item a partir de uma string de pesquisa.
	 * 
	 * @param p - String de pesquisa.
	 * @param id - id do item.
	 * 
	 * @return um item da dada pesquisa que possui o id em questão.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
        return itemController.getItemPorPesquisa(strPesquisada, posicao);
    }
	
	/*
	 * US3
	 */
	
	/**
	 * Método que pesquisa um item numa lista de compras a partir do seu id.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * @param id - id do item.
	 * 
	 * @return O item pesquisado, caso exista.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return listaController.pesquisaCompraEmLista(descritorLista, id);
	}
	
	/**
	 * Método que cria uma nova lista de compras.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * 
	 * @return Retorna o descritor da lista, ou o nome da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return listaController.adicionaListaDeCompras(descritorLista);
	}
	
	/**
	 * Método que pesquisa se a lista de compras existe.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * 
	 * @return Retorna a lista caso a mesma exista.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return listaController.pesquisaListaDeCompras(descritorLista);
	}
	
	/**
	 * Método que adiciona produtos a lista.
	 * 
	 * @param descritorLista - Atributo descritor da lista, ou o nome da lista.
	 * @param quantidade - Quantidade do produto a ser adicionado na lista.
	 * @param item - Item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int id) {
		listaController.adicionaCompraALista(descritorLista, quantidade, itemController.itemToLista(id));
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
		listaController.atualizaCompraDeLista(descritorLista, id, operacao, quantidade);
	}
	
	/**
	 * Método que finaliza a lista de compras.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista.
	 * @param localDeCompra - Estabelecimento onde foi realizado a compra.
	 * @param valorCompra - valor total da lista de compras.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, double valorCompra) {	
		listaController.finalizarListaDeCompras(descritorLista, localDeCompra, valorCompra);
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
		return listaController.getItemLista(descritorLista, posicao);
	}
	
	/**
	 * Método que remove uma compra da lista.
	 * 
	 * @param descritorLista - Descritor da lista, ou o nome da lista. 
	 * @param id - id do item a ser deletado.
	 */
	public void deletaCompraDeLista(String descritorLista, int id) {
		if(!itemController.getItens().containsKey(id))
			throw new IllegalArgumentException("Erro na exclusao de compra: item nao existe no sistema.");
		listaController.deletaCompraDeLista(descritorLista, id);
	}
	
	/*
	 *  US4
	 */
	
	/**
	 * Método que retorna a data atual.
	 * 
	 * @return Retorna a data atual.
	 */
	public String dataAtual() {
		String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date());
		return data;
	}
	
	/**
	 * Método que pega o item da lista pela Data.
	 * 
	 * @param data - Atributo data, que 
	 * @param posicao
	 * @return
	 */
	public String getItemListaPorData(String data, int posicao) {
		ArrayList<ListaDeCompras> listaData = pesquisaListaDeComprasPorData(data);
		if(posicao >= listaData.size())
			throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		return listaData.get(posicao).getDescricao();
	}
	
	/**
	 * Método que pesquisa uma lista de compras a partir da sua data.
	 * @param data - data da lista.
	 * @return - Retorna a lista pesquisada.
	 */
	public ArrayList<ListaDeCompras> pesquisaListaDeComprasPorData(String data) {
		return listaController.pesquisaListaPorData(data);
	}
	
	/**
	 * Método que pega lista especifica que contém um determinado item.
	 * 
	 * @param id - id do item.
	 * @param posicao - posição do item na lista.
	 * 
	 * @return Retorna a lista.
	 */
	public String getItemListaPorItem(int id, int posicao) {
		ArrayList<ListaDeCompras> lista = pesquisaListasDeComprasPorItem(id);
		return lista.get(posicao).dataString() + " - " + lista.get(posicao).getDescricao();
	}
	
	/**
	 * Método que pesquisa uma lista de compras a partir do id de um item.
	 * 
	 * @param id - id de um item.
	 * 
	 * @return Retorna a lista pesquisada.
	 */
	public ArrayList<ListaDeCompras> pesquisaListasDeComprasPorItem(int id) {
		return listaController.pesquisaItemListaPorItem(id);
	}
	
	/*
	 * US5
	 */
	
	/**
	 * Método que gera automáticamente a ultima lista criada.
	 * 
	 * @return Retorna uma lista de compras.
	 */
	public String geraAutomaticaUltimaLista() {
		return listaController.geraAutomaticaUltimaLista();
	}
	
	/**
	 * Método que gera automáticamente a ultima lista em que o item pesquisado esteve presente.
	 * 
	 * @param descritorItem - Produto a ser pesquisado.
	 * 
	 * @return Retorna uma lista automática.
	 */
	public String geraAutomaticaItem(String descritorItem) {
		int ix = 1;
		for(Item i : itemController.getItens().values()) {
			if(i.getNome().equals(descritorItem)) {
				ix = i.getId();
				break;
			}
		}
		
		return listaController.geraAutomaticaItem(itemController.getItens().get(ix));
	}
	
	/**
	 * Método que gera uma lista de compras com os itens de compras que mais aparecem nas listas de compras anteriores.
	 * 
	 * @return Retorna uma lista de compras.
	 */
	public String geraAutomaticaItensMaisPresentes() {
		ListaDeCompras list = new ListaDeCompras(null);
		for(Item i: itemController.getItens().values()) {
			int cont = 0;
			int quantidades = 0;
			for(ListaDeCompras l : listaController.getListas().values()) {
				if(l.listaItens().contains(i)) {
					cont++;
					quantidades+= l.pesquisaItemCompraEmLista(i.getId()).getQuantidade();
				}
			};
			if(cont>= (listaController.getListas().size()/2)) {
				list.addItem((int)Math.floor(quantidades/cont), i);
			}
		}
		list.setDescricao("Lista automatica 3 "  + java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
		listaController.addLista(list);
		return list.getDescricao();
	}
	
	/*
	 * US6
	 */
	
	/**
	 * Método que auxilia o usuário a encontrar o melhor estabelecimento para suas compras a partir de uma lista de compras.
	 * 
	 * @param descritorLista - Descritor da lista, ou nome da lista.
	 * @param posEstabelecimento - Posição do estabelecimento na lista. 
	 * @param posLista - Posição do item na lista de itens do estabelecimento.
	 * 
	 * @return Retorna ou o preço do item em um determinado estabelecimento ou o nome do estabelecimento.
	 */
	public String sugereMelhorEstabelecimento(String descritorLista, int posEstabelecimento, int posLista){
		ArrayList<ListaDeCompras> list = pesquisaPrecoEstabelecimento(listaController.getListas().get(descritorLista));
		if(list.size() == 0) {
			throw new IllegalArgumentException("Faltam dados para informar sobre preços em locais de compras.");
		}
		if(posLista == 0) {
			String s = String.format("%.2f",list.get(posEstabelecimento).getValorCompra()).replace(".",",");
			return list.get(posEstabelecimento).getDescricao() + ": R$ " + (String) s;
		}
		if(posLista-1 >= list.get(posEstabelecimento).listaItens().size())
			return "";
		return list.get(posEstabelecimento).itemString(list.get(posEstabelecimento).listaItens().get(posLista-1));
									
	}
	
	/**
	 * Método que pesquisa o preço dos itens em cada estabelecimento.
	 * 
	 * @param l - Lista de compras.
	 * 
	 * @return - Retorna a lista de estabelecimentos com os preços dos itens. 
	 */
	public ArrayList<ListaDeCompras> pesquisaPrecoEstabelecimento(ListaDeCompras l){
		HashMap<String, ListaDeCompras> list = new HashMap<String, ListaDeCompras>();
		for(Compra c: l.getCompras()) {
			for(Item i : itemController.getItens().values()) {
				if(c.getItem().equals(i)) {
					for(String s: i.getPrecos().keySet()) {
						if(list.containsKey(s)) {
							list.get(s).addItem(c.getQuantidade(), i);
						}else {
							list.put(s, new ListaDeCompras(s));
							list.get(s).addItem(c.getQuantidade(), i);
						}
					}
					break;
				}
			}
		}
		ArrayList<ListaDeCompras> lista2 = new  ArrayList<ListaDeCompras>();
		for(ListaDeCompras lx: list.values()) {
			double valor = 0;
			for(Compra c: lx.getCompras()) {
				for(String s : c.getItem().getPrecos().keySet()) {
					if(lx.getDescricao().equals(s))
						valor+= c.getQuantidade() * c.getItem().getPrecos().get(s).doubleValue();
				}
			}
			lx.setValorCompra(valor);
			lista2.add(lx);
		}
		lista2.sort(new ComparadorListaPrecoFinal());
		
		return lista2;
	}
	
	/*
	 * US7
	 */
	
	/**
	 * Método que carrega os itens e as listas armazenadas e inicia o sistema.
	 */
	public void iniciaSistema() {
		itemController.setItens(SerializeSistema.carregaItens());
		listaController.setListas(SerializeSistema.carregaListas());
	}
	
	/**
	 * Método que armazena e salva os itens e as listas e finaliza o sistema. 
	 */
	public void fechaSistema() {
		SerializeSistema.salvarItens(itemController.getItens());
		SerializeSistema.salvarListas(listaController.getListas());
	}
	
	
}
