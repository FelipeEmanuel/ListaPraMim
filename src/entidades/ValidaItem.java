package entidades;

public class ValidaItem {
	
	public static void valida(String nome, String categoria, String localDeCompra, double preco) {
		if(nome.isEmpty() || nome.equals(null))
			throw new IllegalArgumentException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		if(categoria.isEmpty() || categoria.equals(null))
			throw new Error("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		if(!categoria.toLowerCase().equals("alimento industrializado") 
				&& !categoria.toLowerCase().equals("alimento nao industrializado")
				&& !categoria.toLowerCase().equals("higiene")
				&& !categoria.toLowerCase().equals("limpeza"))
			throw new Error("Erro no cadastro de item: categoria nao existe.");
		if(localDeCompra.isEmpty() || localDeCompra.equals(null))
			throw new IllegalArgumentException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
		if(preco<=0)
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
	}

	public static void validaQuilo(String nome , String categoria , String localDeCompra, double preco, double kg) {
		valida(nome, categoria, localDeCompra, preco);
		if(kg<0.0)
			throw new Error("Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
	}
	
	public static void validaQTD(String nome, String categoria, int quantidade, String unidade, String localDeCompra,double preco) {
		valida(nome, categoria, localDeCompra, preco);
		if(unidade.isEmpty() || unidade.equals(null))
			throw new Error("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");
		if(quantidade<0)
			throw new Error("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
	}
	
	public static void validaUnidade(String nome, String categoria, String localDeCompra, double preco, int unidade) {
		valida(nome, categoria, localDeCompra, preco);
		if(unidade<0)
			throw new Error("Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
	}
	
}
