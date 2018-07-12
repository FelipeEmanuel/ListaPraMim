package view;

public class Main {

	public static void main(String[] args) {
		Facade facade = new Facade();
		
		facade.addProdutos("A", "Higiene", "por unidade");
		facade.addProdutos("C", "Higiene", "quantidade fixa");
		facade.addProdutos("B", "Higiene", "por unidade");
		System.out.println(facade.pesquisaItens());
		System.out.println(facade.pesquisaCategorias("Higiene"));
		Integer id = 1;
		System.out.println(facade.pesquisaItem(id));
		System.out.println(facade.pesquisa("HiGiene"));
		
	}

}
