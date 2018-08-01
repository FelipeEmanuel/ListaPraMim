package comparators;

/**
 * Classe responsável por implementar a interface Comparator e criar um critério de comparação de listas.
 * Critério pela descrição da lista.
 * 
 * Laboratório de Programação 2 - Projeto Final
 * 
 * @author Amanda Souza Magalhães - 116210439 
 * @author Felipe Emanuel de Farias Nunes - 117211052
 * @author Matheus Alves do Nascimento - 117110780
 *
 */

import java.util.Comparator;

import entidades.Item;
import entidades.ListaDeCompras;

public class ComparadorLista  implements Comparator<ListaDeCompras>{
		public int compare(ListaDeCompras l1, ListaDeCompras l2) {
			return l1.getDescricao().toLowerCase().compareTo(l2.getDescricao().toLowerCase());
		}
		
}
