package util;

/**
* Classe que checa os erros das Listas de compras.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

public class exceptions {
	
	/**
	 * Método responsável por fazer atualização na lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
	 */
	public static String compraNãoEncontradaException() {
		throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
	}
	
	/**
	 * Método responsável por verificar pesquisas numa lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
	 */
	public static String compraNãoEncontradaPesquisaException() {
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}
	
	/**
	 * Método responsável por verificar pesquisas numa lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
	 */
	public static String listaDeComprasNaoExisteException() {
		throw new IllegalArgumentException("Erro na pesquisa de compra: lista de compras nao existe.");
	}
	
	/**
	 * Método responsável por verificar o cadastro de itens. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
 	 */
	public static String itemJaCadastrado() {
		throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
	}
	
	/**
	 * Método responsável por verificar a listagem de itens. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
	 */
	public static String itemNaoExiste() {
		throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");
	}
	
	/**
	 * Método responsável por verificar o cadastro de itens. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
	 */
	public static String itemNaoExisteCadastroPreco() {
		throw new IllegalArgumentException("Erro no cadastro de preco: item nao existe.");
	}
	
	/**
	 * Método responsável por verificar a atualização de itens. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
	 */
	public static String itemNaoExisteAtualizacao() {
		throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
	}
	
	/**
	 * Método responsável por verificar a compra de um item. Lança exceção em caso de irregularidade.
	 * 
	 * @return Retorna uma exceção.
	 */
	public static String itemNaoExisteCompra() {
		throw new IllegalArgumentException("Erro na compra de item: item nao existe no sistema.");
	}
	
	/**
	 * Método responsável por verificar a unidade de medida de um item. Lança exceção em caso de irregularidade.
	 * @return
	 */
	public static String itemNaoPossuiUnidadeDeMedida() {
		throw new IllegalArgumentException("Item não possui unidade de medida.");
	}
	
}
