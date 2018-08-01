package util;

import java.text.DateFormat;
import java.util.Date;

public class Check {
	
	public static void checkNomeItem(String nome) {
		if(nome.isEmpty() || nome.equals(null))
			throw new IllegalArgumentException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
	}

	
	public static void checkCategoriaItem(String categoria) {
		if(categoria.isEmpty() || categoria.equals(null))
			throw new Error("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		if(!categoria.toLowerCase().equals("alimento industrializado") 
				&& !categoria.toLowerCase().equals("alimento nao industrializado")
				&& !categoria.toLowerCase().equals("higiene pessoal")
				&& !categoria.toLowerCase().equals("limpeza"))
			throw new Error("Erro no cadastro de item: categoria nao existe.");		
	}

	
	public static void checkCategoriaItemListagem(String categoria) {
		if(categoria.isEmpty() || categoria.equals(null))
			throw new Error("Erro na listagem de item: categoria nao pode ser vazia ou nula.");
		if(!categoria.toLowerCase().equals("alimento industrializado") 
				&& !categoria.toLowerCase().equals("alimento nao industrializado")
				&& !categoria.toLowerCase().equals("higiene pessoal")
				&& !categoria.toLowerCase().equals("limpeza"))
			throw new Error("Erro na listagem de item: categoria nao existe.");		
	}
	
	public static void checkLocalCompra(String localDeCompra) {
		if(localDeCompra.isEmpty() || localDeCompra.equals(null))
			throw new IllegalArgumentException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
	}


	public static void checkPreco(double preco) {
		if(preco<=0)
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
	}
	
	public static void checkPrecoCadastroPreco(double preco) {
		if(preco <= 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
	}
	
	
	
	public static void checkKg(double kg) {
		if(kg<0.0)
			throw new Error("Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
	}

	
	public static void checkUnidadeMedida(String unidade) {
		if(unidade.isEmpty() || unidade.equals(null))
			throw new Error("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");
	}
	
	
	public static void checkValorUnidadeMedida(int quantidade) {
		if(quantidade<0)
			throw new Error("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
	}
	
	
	public static void checkUnidade(int unidade) {
		if(unidade<0)
			throw new Error("Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
	}
	
	
	public static void checkDescritorListaCriacao(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
	}
	
	
	public static void checkDescritorListaPesquisa(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
	}
	
	
	public static void checkIdPesquisa(int id) {
		if(id <= 0)
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");
	}
	
	public static void checkIdCadastroPreco(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
	}
	
	public static void checkIdListagem(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
	}
	
	
	public static void checkDescritorListaFinalizacao(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
	}
	
	
	public static void checkLocalDeCompraFinalizacao(String localDeCompra) {
		if (localDeCompra.trim().isEmpty() || localDeCompra == null)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
	}
	
	public static void checkLocalDeCompraCadastroPreco(String localDeCompra) {
		if(localDeCompra.isEmpty() || localDeCompra == null)
			throw new IllegalArgumentException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
	}
	
	
	public static void checkValorCompra(double valorCompra) {
		if (valorCompra <= 0)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: valor final da lista invalido.");
	}
	
	
	public static void checkDescritorDeletaCompraDeLista(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
	}
	
	
	public static void checkDataPesquisaListaPorData(String data) {
		if (!data.equals(java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date())) && !(data.isEmpty() || data == null))
			throw new IllegalArgumentException("Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
	}
	
	
	public static void checkValorAtualizacao(String valor) {
		if	(valor == null || valor.isEmpty())
			throw new IllegalArgumentException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
		
	}
	
	
	public static void checkAtributoAtualizacao(String atributo) {
		if	(atributo == null || atributo.isEmpty())
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
	}
	
	
	public static void checkValorAtualizacaoCategoria(String valor) {
		if(!valor.toLowerCase().equals("alimento industrializado") 
				&& !valor.toLowerCase().equals("alimento nao industrializado")
				&& !valor.toLowerCase().equals("higiene pessoal")
				&& !valor.toLowerCase().equals("limpeza"))
			throw new Error("Erro na atualizacao de item: categoria nao existe.");
	}
	
	

}
