package comparators;

import entidades.Item;

public class ComparadorPreco {
	public int compare(Item i1, Item i2) {
		return i1.getNome().compareTo(i2.getNome());
	}
}
