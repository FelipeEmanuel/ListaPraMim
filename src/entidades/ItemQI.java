package entidades;

/**
* Classe que trata itens com quantidade fixa.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

import java.util.HashMap;

public class ItemQI extends Item {

	private String unidadeMedida;
	private int valorMedida;
	
	/**
	 * Método construtor de itemQI. 
	 * 
	 * @param nome - Nome do item.
	 * @param categoria - Categoria do item.
	 * @param id - id do item.
	 * @param valor - Quantidade do item.
	 * @param unidade - Unidade de medida do item.
	 */
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
		
	/**
	 * Método que adiciona o preço de um item em um determinado local.
	 */
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
