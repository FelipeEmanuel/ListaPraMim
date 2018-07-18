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
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Item getItem() {
		return item;
	}
	
}
