package entidades;

import java.util.HashMap;



public class ItemUnidade extends Item {


	public ItemUnidade(String nome, String categoria, int id) {
		super(nome, categoria, id);
	}

	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + ","+ "Preço:" + precos.toString();
	}

	@Override
	public void addPreco(String supermercado, double preco) {
		precos.put(supermercado, preco);
	}


	

}
