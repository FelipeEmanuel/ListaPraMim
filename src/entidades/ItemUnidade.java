package entidades;

/**
* Classe que trata itens por unidade.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

import java.util.HashMap;

public class ItemUnidade extends Item {
	
	private int unidade;
	
	/**
	 * Método construtor da classe ItemUnidade.
	 * 
	 * @param nome - Nome do item.
	 * @param categoria - Categoria do item.
	 * @param id - id do item.
	 * @param unidade - Valor em unidades de cada item.
	 */
	public ItemUnidade(String nome, String categoria, int id, int unidade) {
		super(nome, categoria, id);
		setUnidade(unidade);
	}

	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + ", "+ "Preco:" + getPreco();
	}
	
	public String toStringCompra() {
		return  getNome() + ", " + getCategoria();
	}
	
	/**
	 * Método que adiciona preço a itens em um determinado estabelecimento.
	 */
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
