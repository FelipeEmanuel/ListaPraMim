package entidades;

import java.io.Serializable;

public class Compra implements Serializable{
	
	private int quantidade;
	private Item item;
	
	public Compra(int quantidade, Item item) {
		setQuantidade(quantidade);
		this.item = item;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public void adicionaQuantidade(int plus) {
		this.quantidade += plus;
	}
	
	public void diminuiQuantidade(int minus) {
		quantidade += (-1*minus);
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Item getItem() {
		return item;
	}
	
	@Override
	public String toString() {
		return quantidade + " " + item.toStringCompra();
	}
}
