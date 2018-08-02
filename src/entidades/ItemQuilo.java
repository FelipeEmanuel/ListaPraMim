package entidades;

/**
* Classe que trata itens por quilo.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

public class ItemQuilo extends Item {

	private double kg;
	
	/**
	 * Método construtor de ItemQuilo.
	 * 
	 * @param nome - Nome do item.
	 * @param categoria - Categoria do item.
	 * @param kg - Quantidad em quilos do item.
	 * @param id - id do item.
	 */
	public ItemQuilo(String nome, String categoria, double kg, int id) {
		super(nome, categoria, id);
		this.kg = kg;	
	}

	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + ", " + "Preco por quilo:" + getPreco();
	}
	
	public String toStringCompra() {
		return getNome() + ", " + getCategoria();
	}
	
	/**
	 * Método que adiciona preço a um item em um determinado local.
	 */
	@Override
	public void addPreco(String supermercado, double preco) {
		precos.put(supermercado, preco);
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}

}
