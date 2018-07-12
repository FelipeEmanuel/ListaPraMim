package entidades;

import java.util.HashMap;

public class Item implements Comparable<Item>{
	
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

}
