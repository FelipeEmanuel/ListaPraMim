package entidades;

public class Item implements Comparable<Item>{
	
	private String nome;
	private String categoria;
	
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

}
