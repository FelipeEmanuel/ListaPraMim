package entidades;

import java.util.HashMap;


public class ItemQI extends Item {

	private String unidadeMedida;
	private int valorMedida;
	
	public ItemQI(String nome, String categoria, int id) {
		super(nome, categoria, id);
	}

	
	
	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + ","+ getValorMedida() + getUnidadeMedida() + "Preço:" + precos.toString();
	}

	@Override
	public void addPreco(String supermercado, double preco) {
		precos.put(supermercado, preco);
	}



	public String getUnidadeMedida() {
		return unidadeMedida;
	}



	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}



	public int getValorMedida() {
		return valorMedida;
	}



	public void setValorMedida(int valorMedida) {
		this.valorMedida = valorMedida;
	}


	


}
