package entidades;

public class Compra {
	
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
		quantidade += plus;
	}
	
	public void diminuiQuantidade(int minus) {
		quantidade -= minus;
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
