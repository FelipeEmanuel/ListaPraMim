package comparators;

import java.util.Comparator;

import entidades.Item;
import entidades.ListaDeCompras;

public class ComparadorLista  implements Comparator<ListaDeCompras>{
		public int compare(ListaDeCompras l1, ListaDeCompras l2) {
			return l1.getDescricao().toLowerCase().compareTo(l2.getDescricao().toLowerCase());
		}
		
}
