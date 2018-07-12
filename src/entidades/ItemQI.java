package entidades;

import java.util.HashMap;


public class ItemQI extends Item {


	public ItemQI(String nome, String categoria, int id) {
		super(nome, categoria, id);
	}

	private String quantidade;
	
	
	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + "," + getQuantidade() + "Preço:" + precos.toString();
	}

	@Override
	public void addPreco(String supermercado, double preco) {
		precos.put(supermercado, preco);
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	


}
