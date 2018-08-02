package util;

/**
* Classe que checa os erros da Lista.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

public class CheckLista {
	
	/**
	 * Método responsável por verificar a criação de uma lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @param descritorLista - Descritor da lista, ou nome da lista.
	 */
	public static void checkDescritorListaCriacao(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
	
}
