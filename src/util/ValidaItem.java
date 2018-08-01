package util;

public class ValidaItem {
	
	public static void valida(String nome, String categoria, String localDeCompra, double preco) {
		Check.checkNomeItem(nome);
		Check.checkCategoriaItem(categoria);
		Check.checkLocalCompra(localDeCompra);
		if(preco<=0)
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
	}

	public static void validaQuilo(String nome , String categoria , String localDeCompra, double preco, double kg) {
		valida(nome, categoria, localDeCompra, preco);
		Check.checkKg(kg);
	}
	
	public static void validaQTD(String nome, String categoria, int quantidade, String unidade, String localDeCompra,double preco) {
		valida(nome, categoria, localDeCompra, preco);
		Check.checkUnidadeMedida(unidade);
		Check.checkValorUnidadeMedida(quantidade);
	}
	
	public static void validaUnidade(String nome, String categoria, String localDeCompra, double preco, int unidade) {
		valida(nome, categoria, localDeCompra, preco);
		Check.checkUnidade(unidade);
	}
	
}
