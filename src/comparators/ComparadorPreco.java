package comparators;

import java.util.Comparator;

import entidades.Item;

public class ComparadorPreco implements Comparator<Item>{
	public int compare(Item i1, Item i2) {
		return i1.menorPreco().compareTo(i2.menorPreco());
	}
}
