package util;

public class exceptions {
	
	public static String compraNãoEncontradaException() {
		throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
	}
	
	public static String compraNãoEncontradaPesquisaException() {
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}
	
	
	public static String listaDeComprasNaoExisteException() {
		throw new IllegalArgumentException("Erro na pesquisa de compra: lista de compras nao existe.");
	}
	
	public static String itemJaCadastrado() {
		throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
	}
	
	public static String itemNaoExiste() {
		throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");
	}
	
	public static String itemNaoExisteCadastroPreco() {
		throw new IllegalArgumentException("Erro no cadastro de preco: item nao existe.");
	}
	
	public static String itemNaoExisteAtualizacao() {
		throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
	}
	
	public static String itemNaoExisteCompra() {
		throw new IllegalArgumentException("Erro na compra de item: item nao existe no sistema.");
	}
	
	
	public static String itemNaoPossuiUnidadeDeMedida() {
		throw new IllegalArgumentException("Item não possui unidade de medida.");
	}
	
	
	
}
