package entidades;

import java.util.HashMap;


public class ItemQI extends Item {

	private String unidadeMedida;
	private int valorMedida;
	
	public ItemQI(String nome, String categoria, int id, int valor , String unidade) {
		super(nome, categoria, id);
		setUnidadeMedida(unidade);
		setValorMedida(valor);
	}

	
	
	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + ", "+ getValorMedida() + " " + getUnidadeMedida() + ", Preco:" + getPreco();
	}
	
	public String toStringCompra() {
		return getNome() + ", " + getCategoria() + ", " + getValorMedida() + " " + getUnidadeMedida();
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
