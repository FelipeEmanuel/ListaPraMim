package testes_de_unidade;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.ItemQI;
import entidades.ItemUnidade;
import entidades.ListaDeCompras;

class ListaDeComprasTest {

	@Test
	void testAdicionaItem() {
		ListaDeCompras lista = new ListaDeCompras("Primeira Lista");
		ItemQI item1 = new ItemQI("Molho de Soja Shoyu Tradicional", "alimento industrializado", 1, 6, "1");
		ItemUnidade item2 = new ItemUnidade("Escova de Dentes de Bambu", "higiene pessoal", 2, 2);
		lista.addItem(2, item1);
		lista.addItem(3, item2);
	}
	
	@Test
	void testDescricao() {
		ListaDeCompras lista = new ListaDeCompras("Minha lista");
		assertEquals("Minha lista", lista.getDescricao());
		lista.setDescricao("Nova descricao");
		assertEquals("Nova descricao", lista.getDescricao());
	}
	
	@Test
	void testLocalDeCompra() {
		ListaDeCompras lista = new ListaDeCompras("Primeira Lista");
		ItemQI item1 = new ItemQI("Molho de Soja Shoyu Tradicional", "alimento industrializado", 1, 6, "1");
		lista.addItem(1, item1);
		assertEquals(null, lista.getLocalDeCompra());
		lista.setLocalDeCompra("Wallmart");
		assertEquals("Wallmart", lista.getLocalDeCompra());
	}

}
