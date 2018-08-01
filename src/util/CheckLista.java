package util;

public class CheckLista {
	
	public static void checkDescritorListaCriacao(String descritorLista) {
		if (descritorLista.trim().isEmpty() || descritorLista == null)
			throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

	
	
	
}
