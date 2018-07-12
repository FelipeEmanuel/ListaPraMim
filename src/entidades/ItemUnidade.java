package entidades;

import java.util.HashMap;



public class ItemUnidade extends Item {
	private String nome;
	private String categoria;
	private int id;
	private HashMap<String, Double> precos;
	
	public ItemUnidade(String nome, String categoria, int id) {
		this.nome = nome;
		this.categoria = categoria;
		this.id = id;
		precos = new HashMap<String, Double>();
	}

	@Override
	public String toString() {
		return id + ". " + nome + ", " + categoria + ","+ "Preço:" + precos.toString();
	}

	@Override
	public void addPreco(String supermercado, double preco) {
		precos.put(supermercado, preco);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + id;
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
		ItemUnidade other = (ItemUnidade) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	

}
