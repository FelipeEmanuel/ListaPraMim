package util;

/**
* Classe que checa os erros da classe Item.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

public class ValidaItem {
	
	/**
	 * Método responsável por validar a criação de itens. Lança exceção em caso de irregularidade.
	 *  
	 * @param nome - Nome do item.
	 * @param categoria - Categoria do item.
	 * @param localDeCompra - Estabelecimento da compra.
	 * @param preco - Preço do item.
	 */
	public static void valida(String nome, String categoria, String localDeCompra, double preco) {
		Check.checkNomeItem(nome);
		Check.checkCategoriaItem(categoria);
		Check.checkLocalCompra(localDeCompra);
		if(preco<=0)
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
	}
	
	/**
	 * Método responsável por validar a criação de itens não industrializados por quilo. Lança exceção em caso de irregularidade.
	 * 
	 * @param nome - Nome do item.
	 * @param categoria - Categoria do item.
	 * @param localDeCompra - Estabelecimento da compra.
	 * @param preco - Preço do item.
	 * @param kg - Valor em quilos do item.
	 */
	public static void validaQuilo(String nome , String categoria , String localDeCompra, double preco, double kg) {
		valida(nome, categoria, localDeCompra, preco);
		Check.checkKg(kg);
	}
	
	/**
	 * Método responsável por validar a criação de itens por quantidade fixa. Lança exceção em caso de irregularidade.
	 * 
	 * @param nome - Nome do Item.
	 * @param categoria - Categoria do item.
	 * @param quantidade - Quantidade do item.
	 * @param unidade - Unidade de medida do item.
	 * @param localDeCompra - Estabelecimento da compra.
	 * @param preco - Preço do item.
	 */
	public static void validaQTD(String nome, String categoria, int quantidade, String unidade, String localDeCompra,double preco) {
		valida(nome, categoria, localDeCompra, preco);
		Check.checkUnidadeMedida(unidade);
		Check.checkValorUnidadeMedida(quantidade);
	}
	
	/**
	 * Método responsável por validar a criação de itens por unidade. Lança exceção em caso de irregularidade.
	 * 
	 * @param nome - Nome do item.
	 * @param categoria - Categoria do item.
	 * @param localDeCompra - Estabelecimento da compra.
	 * @param preco - Preço do item.
	 * @param unidade - Quantidade do item.
	 */
	public static void validaUnidade(String nome, String categoria, String localDeCompra, double preco, int unidade) {
		valida(nome, categoria, localDeCompra, preco);
		Check.checkUnidade(unidade);
	}
	
}
