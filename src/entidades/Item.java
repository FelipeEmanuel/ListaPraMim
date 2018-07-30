package entidades;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Item implements Comparable<Item>, Serializable{
	
	private String nome;
	private String categoria;
	private int id;
	protected HashMap<String, Double> precos;
	
	public Item(String nome, String categoria, int id) {
		setNome(nome);
		setCategoria(categoria);
		this.id = id;
		precos = new HashMap<String, Double>();
	}
	
	public void addPreco(String supermercado, double preco) {
	}
	
	@Override
	public int compareTo(Item i) {
		return this.getNome().compareTo(i.getNome());
	}
	
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
	
	public String getPreco() {
		String retorno = " <";
		for(String s: precos.keySet()) {
			String p =precos.get(s).toString();
			retorno += s + ", R$ " + (precos.get(s).toString().format("%.2f", precos.get(s)).replace(".", ",")) + ";";
		}
		retorno += ">";
		return retorno;
	}
	
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
	
	public abstract String toStringCompra() ;

	
}
