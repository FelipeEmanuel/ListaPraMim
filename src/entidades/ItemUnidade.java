package entidades;

import java.util.HashMap;



public class ItemUnidade extends Item {

	
	private int unidade;

	public ItemUnidade(String nome, String categoria, int id,int unidade) {
		super(nome, categoria, id);
		setUnidade(unidade);
	}

	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + ","+ "Preço:" + precos.toString();
	}

	@Override
	public void addPreco(String supermercado, double preco) {
		precos.put(supermercado, preco);
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}


	

}
