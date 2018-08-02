package util;

/**
* Classe que checa os erros da classe Item e da classe ListaDeCompras.
* 
* Laboratório de Programação 2 - Projeto Final
* 
* @author Amanda Souza Magalhães - 116210439 
* @author Felipe Emanuel de Farias Nunes - 117211052
* @author Matheus Alves do Nascimento - 117110780
*
*/

import java.text.DateFormat;
import java.util.Date;

public class Check {
	
	/**
	 * Metodo responsável por validar o atributo nome. Lança exceção em caso de irregularidade.
	 *  
	 * @param nome - Nome do item.
	 */
	public static void checkNomeItem(String nome) {
		if(nome.isEmpty() || nome.equals(null))
			throw new IllegalArgumentException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método responsável por validar o atributo categoria. Lança exceção em caso de irregularidade.
	 * 
	 * @param categoria - Categoria do item.
	 */
	public static void checkCategoriaItem(String categoria) {
		if(categoria.isEmpty() || categoria.equals(null))
			throw new Error("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		if(!categoria.toLowerCase().equals("alimento industrializado") 
				&& !categoria.toLowerCase().equals("alimento nao industrializado")
				&& !categoria.toLowerCase().equals("higiene pessoal")
				&& !categoria.toLowerCase().equals("limpeza"))
			throw new Error("Erro no cadastro de item: categoria nao existe.");		
	}
	
	/**
	 * Método responsável por validar o atributo categoria. Lança exceção em caso de irregularidade.
	 * 
	 * @param categoria - Categoria do item.
	 */
	public static void checkCategoriaItemListagem(String categoria) {
		if(categoria.isEmpty() || categoria.equals(null))
			throw new Error("Erro na listagem de item: categoria nao pode ser vazia ou nula.");
		if(!categoria.toLowerCase().equals("alimento industrializado") 
				&& !categoria.toLowerCase().equals("alimento nao industrializado")
				&& !categoria.toLowerCase().equals("higiene pessoal")
				&& !categoria.toLowerCase().equals("limpeza"))
			throw new Error("Erro na listagem de item: categoria nao existe.");		
	}
	
	/**
	 * Método responsável por validar o local de compra. Lança exceção em caso de irregularidade.
	 * 
	 * @param localDeCompra - Estabelecimento em que se compra o item.
	 */
	public static void checkLocalCompra(String localDeCompra) {
		if(localDeCompra.isEmpty() || localDeCompra.equals(null))
			throw new IllegalArgumentException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
	}

	/**
	 * Método responsável por validar o preço do item. Lança exceção em caso de irregularidade.
	 * 
	 * @param preco - Preço do item.
	 */
	public static void checkPreco(double preco) {
		if(preco<=0)
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
	}
	
	/**
	 * Método responsável por validar o preço do item. Lança exceção em caso de irregularidade.
	 * 
	 * @param preco - Preço do item.
	 */
	public static void checkPrecoCadastroPreco(double preco) {
		if(preco <= 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
	}
	
	/**
	 * Método responsável por checar o kg de um item. Lança exceção em caso de irregularidade.
	 * 
	 * @param kg - Kg de um item.
	 */
	public static void checkKg(double kg) {
		if(kg<0.0)
			throw new Error("Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
	}
	
	/**
	 * Método responsável por checar a unidade de medida de um item. Lança exceção em caso de irregularidade.
	 * 
	 * @param unidade - Unidade de medida do item.
	 */
	public static void checkUnidadeMedida(String unidade) {
		if(unidade.isEmpty() || unidade.equals(null))
			throw new Error("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");
	}
	
	/**
	 * Método responsável por checar a quantidade do item. Lança exceção em caso de irregularidade.
	 * 
	 * @param quantidade - quantidade do item.
	 */
	public static void checkValorUnidadeMedida(int quantidade) {
		if(quantidade<0)
			throw new Error("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
	}
	
	/**
	 * Método responsável por validar a unidade no cadastro de um item. Lança exceção em caso de irregularidade.
	 * 
	 * @param unidade - Unidade do item.
	 */
	public static void checkUnidade(int unidade) {
		if(unidade<0)
			throw new Error("Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
	}	
	
	/**
	 * Método responsável por validar a criação de uma lista de compras.Lança exceção em caso de irregularidade.
	 * 
	 * @param descritorLista - Descritor da lista, ou nome da lista.
	 */
	public static void checkDescritorListaCriacao(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método responsável por verificar dentro de uma pesquisa se o descritor está correto. Lança exceção em caso de irregularidade.
	 * 
	 * @param descritorLista - Descritor da lista, ou nome da lista.
	 */
	public static void checkDescritorListaPesquisa(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método responsável por verificar erros na pesquisa por id. Lança exceção em caso de irregularidade.
	 * 
	 * @param id - id do item.
	 */
	public static void checkIdPesquisa(int id) {
		if(id <= 0)
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");
	}
	
	/**
	 * Método responsável por verificar erros no cadstros de preço. Lança exceção em caso de irregularidade.
	 * 
	 * @param id - id do item.
	 */
	public static void checkIdCadastroPreco(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
	}
	
	/**
	 * Método responsável por verificar a listagem de itens. Lança exceção em caso de irregularidade.
	 * 
	 * @param id - id do item.
	 */
	public static void checkIdListagem(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
	}
	
	/**
	 * Método responsável por verificar a finalização de uma lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @param descritorLista - Descritor da lista, ou nome da lista.
	 */
	public static void checkDescritorListaFinalizacao(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método responsável por verificar a finalização de uma lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @param localDeCompra - Estabelecimento da compra.
	 */
	public static void checkLocalDeCompraFinalizacao(String localDeCompra) {
		if (localDeCompra.trim().isEmpty() || localDeCompra == null)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método responsável por verificar o cadastro de preço. Lança exceção em caso de irregularidade.
	 * 
	 * @param localDeCompra - Estabelecimento da compra.
	 */
	public static void checkLocalDeCompraCadastroPreco(String localDeCompra) {
		if(localDeCompra.isEmpty() || localDeCompra == null)
			throw new IllegalArgumentException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método responsável por verificar a finalização da lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @param valorCompra - Valor final da lista de compras.
	 */
	public static void checkValorCompra(double valorCompra) {
		if (valorCompra <= 0)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: valor final da lista invalido.");
	}	
	
	/**
	 * Método que verifica a exclusão de uma lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @param descritorLista - Descritor da lista, ou nome da lista.
	 */
	public static void checkDescritorDeletaCompraDeLista(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método que verifica a pesquisa numa lista de compras. Lança exceção em caso de irregularidade.
	 * 
	 * @param data - Data do momento da criação da lista de compras.
	 */
	public static void checkDataPesquisaListaPorData(String data) {
		if (!data.equals(java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date())) && !(data.isEmpty() || data == null))
			throw new IllegalArgumentException("Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
	}
	
	/**
	 * Método responsável por verificar a atualização de um item. Lança exceção em caso de irregularidade.
	 * 
	 * @param valor - Valor de atributo.
	 */
	public static void checkValorAtualizacao(String valor) {
		if	(valor == null || valor.isEmpty())
			throw new IllegalArgumentException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");	
	}
	
	/**
	 * Método responsável por verificar a atualização de um item. Lança exceção em caso de irregularidade.
	 * 
	 * @param atributo - Atributo a ser atualizado.
	 */
	public static void checkAtributoAtualizacao(String atributo) {
		if	(atributo == null || atributo.isEmpty())
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Método responsável por verificar a atualização de um item. Lança exceção em caso de irregularidade.
	 * 
	 * @param valor - Valor a ser alterado.
	 */
	public static void checkValorAtualizacaoCategoria(String valor) {
		if(!valor.toLowerCase().equals("alimento industrializado") 
				&& !valor.toLowerCase().equals("alimento nao industrializado")
				&& !valor.toLowerCase().equals("higiene pessoal")
				&& !valor.toLowerCase().equals("limpeza"))
			throw new Error("Erro na atualizacao de item: categoria nao existe.");
	}
	
}
