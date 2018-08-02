package entidades;

/**
* Classe que faz uma representação abstratica dos itens.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

import java.io.Serializable;
import java.util.HashMap;

import util.ValidaItem;

public abstract class Item implements Comparable<Item>, Serializable{
	
	private String nome;
	private String categoria;
	private int id;
	protected HashMap<String, Double> precos;
	
	/**
	 * Método construtor de Item.
	 * 
	 * @param nome - Nome do item.
	 * @param categoria - Categoria do item.
	 * @param id - id do item.
	 */
	public Item(String nome, String categoria, int id) {
		setNome(nome);
		setCategoria(categoria);
		this.id = id;
		precos = new HashMap<String, Double>();
	}
	
	/**
	 * Método que adiciona preço de um item em um determinado local.
	 * 
	 * @param supermercado - Local onde as compras são realizadas. 
	 * @param preco - Preço do produto no determinado local.
	 * 
	 */
	public void addPreco(String supermercado, double preco) {
		precos.put(supermercado, preco);
	}
	
	/**
	 * Método que compara os nomes dos produtos.
	 */
	@Override
	public int compareTo(Item i) {
		return this.getNome().compareTo(i.getNome());
	}
	
	/**
	 * Método que compara o preço dos itens.
	 * 
	 * @param i - Item a ser comparado.
	 * 
	 * @return Retorna o menor preço entre dois itens.
	 */
	public int compareToPreco(Item i) {
		return this.menorPreco().compareTo(i.menorPreco());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public HashMap<String, Double> getPrecos() {
		return precos;
	}
	
	public void setPrecos(HashMap<String, Double> precos) {
		this.precos = precos;
	}

	public int getId() {
		return this.id;
	}
	
	/**
	 * Método que retorna o preço de um item.
	 * 
	 * @return Retorna o preço de um item dentro de um toString.
	 */
	public String getPreco() {
		String retorno = " <";
		for(String s: precos.keySet()) {
			String p =precos.get(s).toString();
			retorno += s + ", R$ " + (precos.get(s).toString().format("%.2f", precos.get(s)).replace(".", ",")) + ";";
		}
		retorno += ">";
		return retorno;
	}
	
	/**
	 * Método que compara o valor de dois preços.
	 * 
	 * @return Retorna o menor preço.
	 */
	public Double menorPreco() {
		double d = Double.MAX_VALUE;
		for (double x : precos.values()) {
			if(x<d) {
				d = x;
			}
		}
		return d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Item other = (Item) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public abstract String toStringCompra();

}
