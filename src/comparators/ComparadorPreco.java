package comparators;

/**
* Classe responsável por implementar a interface Comparator e criar um critério de comparação de itens.
* Critério pelo menor preço do item.
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

public class ComparadorPreco implements Comparator<Item>{
	public int compare(Item i1, Item i2) {
		return i1.menorPreco().compareTo(i2.menorPreco());
	}
}
