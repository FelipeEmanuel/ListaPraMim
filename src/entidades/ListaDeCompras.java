package entidades;

/**
* Classe que representa as listas de compras.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import comparators.ComparadorNome;

public class ListaDeCompras implements Comparable<ListaDeCompras>, Serializable{
	
	private String descricao;
	private String localDeCompra;
	private double valorCompra;
	private HashSet<Compra> compras;
	private Date data;
	private long  hora;
	
	/**
	 * Método construtor de ListaDeCompras.
	 * 
	 * @param descricao Descrição da lista, ou nome da lista.
	 */
	public ListaDeCompras(String descricao) {
		setDescricao(descricao);
		compras = new HashSet<Compra>();
		data = new Date();
		hora = System.currentTimeMillis();
	}
	
	/**
	 * Método que adiciona um item a lista de compras.
	 * 
	 * @param quantidade - Quantidade de itens a ser adicionado.
	 * @param item - Item a ser adicionado.
	 */
	public void addItem(int quantidade, Item item) {
		compras.add(new Compra(quantidade, item));
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public HashSet<Compra> getCompras() {
		return compras;
	}

	public void setCompras(HashSet<Compra> compras) {
		this.compras = compras;
	}

	public Date getData() {
		return data;
	}
	
	/**
	 * Método que retorna a data de criação da lista como string.
	 * @return retorna a data de criação da lista como string
	 */
	public String dataString() {
		String date = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(getData());
		return date;
	}

	public String getLocalDeCompra() {
		return localDeCompra;
	}

	public void setLocalDeCompra(String localDeCompra) {
		this.localDeCompra = localDeCompra;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public long getHora() {
		return hora;
	}
	
	/**
	 * Método que retorna um item da lista como string.
	 * 
	 * @param item - Item a ser pesquisado.
	 * 
	 * @return Retorna um item da lista como string.
	 */
	public String itemString(Item item){
		for(Compra c: compras) {
			if(c.getItem().equals(item)){
				return "- " + c.getQuantidade()  + " " + c.getItem().toStringCompra();
			}
		}
		return null;
	}
	
	/**
	 * Método que compara o valor final de duas listas de compras.
	 * 
	 * @param l - Listas a serem comparadas.
	 * 
	 * @return Retorna a comparação entre valores.
	 */
	public int compareToPreco(ListaDeCompras l) {
		return this.getValorCompra().compareTo(l.getValorCompra());
	}
	
	/**
	 * Método que compara o nome de duas listas.
	 */
	@Override
	public int compareTo(ListaDeCompras l) {
		return this.getDescricao().compareTo(l.getDescricao());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaDeCompras other = (ListaDeCompras) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String retorno = "";
		for(Compra c : compras) {
			retorno += "\n" + c.getQuantidade() + c.getItem();
		}
		return descricao  + retorno;
	}
	
	/**
	 * Método que pesquisa um item em uma lista de compras.
	 * 
	 * @param id - id do item a ser pesquisado.
	 * 
	 * @return Retorna o item caso o mesmo exista.
	 */
	public String pesquisaCompraEmLista(int id) {
		for (Compra c: compras) {
			if(c.getItem().getId() == id)
				return c.toString();
		}
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}
	
	/**
	 * Método que pesquisa um item em uma lista de compras.
	 * 
	 * @param id - id do item a ser pesquisado.
	 * 
	 * @return Retorna o item caso o mesmo exista.
	 */
	public Compra pesquisaItemCompraEmLista(int id) {
		for (Compra c: compras) {
			if(c.getItem().getId() == id)
				return c;
		}
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}
	
	/**
	 * Método que aumenta a quantidade de um mesmo item.
	 * 
	 * @param id - id do item a ser aumentado.
	 * @param quantidade - valor a ser aumentado.
	 */
	public void addQuantidade(int id, int quantidade) {
		for (Compra c: compras) {
			if(c.getItem().getId() == id)
				c.adicionaQuantidade(quantidade);
		}
	}
	
	/**
	 * Método que diminui a quantidade de um mesmo item.
	 * 
	 * @param id - id do item a ser diminuido.
	 * @param quantidade - valor a ser diminuido.
	 */
	public void diminuiQuantidade(int id, int quantidade) {
		for (Compra c: compras) {
			if(c.getItem().getId() == id) {
				c.diminuiQuantidade(quantidade);
				if(c.getQuantidade()<=0)
					compras.remove(c);
				break;
			}
		}
	}
	
	/**
	 * Método que finaliza a lista de compras.
	 * 
	 * @param localDaCompra - Estabelecimento em que se está sendo realizado a compra.
	 * @param valorFinal - valor total da lista de compras.
	 */
	public void finalizarListaDeCompras(String localDaCompra, double valorFinal) {
		setLocalDeCompra(localDaCompra);
		setValorCompra(valorFinal);
		hora = System.currentTimeMillis();
	}
	
	/**
	 * Método que procura um item dentro de uma lista de compras.
	 * 
	 * @param posicao - Posição do item dentro da lista.
	 * 
	 * @return Retorna o item da posição pesquisada.
	 */
	public String getItemLista(int posicao) {
		ArrayList<Item> itens = listaItens();
		if(posicao >= itens.size())
			return "";
		int q = 0;
		for(Compra c: compras) {
			if(c.getItem().equals(itens.get(posicao))) {
				q = c.getQuantidade();
				return  q + " " + itens.get(posicao).toStringCompra();
			}
		}
		return "";
	}
	
	/**
	 * Método responsável pela lista de itens. 
	 * 
	 * @return Retorna a lista de itens.
	 */
	public ArrayList<Item> listaItens() {
		
		ArrayList<Item> itens = new ArrayList<Item>(),itens2 = new ArrayList<Item>();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("higiene pessoal")) {
				itens2.add(c.getItem());
			}
		}
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}		
		itens2.clear();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("limpeza")) {
				itens2.add(c.getItem());
			}
		}
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}
		itens2.clear();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("alimento industrializado")) {
				itens2.add(c.getItem());
			}
		}
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}
		itens2.clear();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("alimento nao industrializado")) {
				itens2.add(c.getItem());
			}
		}
		
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}
		itens2.clear();
		
		return itens;
	}
	
	/**
	 * Método que remove um item de uma lista de compras.
	 * 
	 * @param id - id do item a ser removido.
	 */
	public void deletaCompraDeLista(int id) {
		for(Compra c : compras) {
			if(c.getItem().getId() == id) {
				compras.remove(c);
				break;
			}
		}
	}

}
