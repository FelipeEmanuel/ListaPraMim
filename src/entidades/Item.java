package entidades;

import java.util.ArrayList;
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
}
