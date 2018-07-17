package entidades;

public class ItemQuilo extends Item {

	private double kg;

	public ItemQuilo(String nome, String categoria, double kg, int id) {
		super(nome, categoria, id);
		this.kg = kg;
		
	}

	@Override
	public String toString() {
		return getId() + ". " + getNome() + ", " + getCategoria() + ", " + "Preco por quilo:" + getPreco();
	}

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
