package comparators;

import java.util.Comparator;

import entidades.Item;
import entidades.ListaDeCompras;

public class ComparadorListaPrecoFinal implements Comparator<ListaDeCompras> {
	public int compare(ListaDeCompras l1, ListaDeCompras l2) {
		return l1.getValorCompra().compareTo(l2.getValorCompra());
	}
}
