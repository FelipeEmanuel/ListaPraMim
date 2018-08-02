package entidades;

/**
* Classe que representa as compras da lista.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/
import java.io.Serializable;

public class Compra implements Serializable{
	
	private int quantidade;
	private Item item;
	
	/**
	 * Método construtor de Compra.
	 * 
	 * @param quantidade - Quantidade do item.
	 * @param item - Item comprado.
	 */
	public Compra(int quantidade, Item item) {
		setQuantidade(quantidade);
		this.item = item;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	/**
	 * Método para adicionar uma determinada quantidade a um item.
	 * 
	 * @param plus - Quantidade adicionada.
	 */
	public void adicionaQuantidade(int plus) {
		this.quantidade += plus;
	}
	
	/**
	 * Método para decrescentar uma determinada quantidade a um item.
	 * 
	 * @param minus - Quantidade decrescida.
	 */
	public void diminuiQuantidade(int minus) {
		quantidade += (-1*minus);
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Item getItem() {
		return item;
	}
	
	/**
	 * toString sobreescrito. 
	 */
	@Override
	public String toString() {
		return quantidade + " " + item.toStringCompra();
	}
	
}
