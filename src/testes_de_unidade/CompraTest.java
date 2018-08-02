package testes_de_unidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entidades.Item;
import entidades.ItemQI;
import entidades.ItemQuilo;
import entidades.ItemUnidade;
import entidades.Compra;

class CompraTest {

	@Test
	void testCompra() {
		ItemQuilo item3 = new ItemQuilo("limao", "alimento nao industrializado", 2.0, 3);
		Compra compra1 = new Compra(5, item3);
		assertEquals(5, compra1.getQuantidade());
		ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		Compra compra2 = new Compra(2, item2);
		assertEquals(2, compra2.getQuantidade());
	}
	
	@Test
	void testAdicionaQuantidade() {
		ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		Compra compra2 = new Compra(10, item2);
		assertEquals(10, compra2.getQuantidade());
		compra2.adicionaQuantidade(3);
		assertEquals(13, compra2.getQuantidade());
	}
	
	@Test
	void testDiminuiQuantidade() {
		ItemQI item1 = new ItemQI("Pepero Biscoito de Palito de Chocolate", "alimento industrializado", 1, 6, "4");
		Compra compra3 = new Compra(3, item1);
		compra3.diminuiQuantidade(2);
		assertEquals(1, compra3.getQuantidade());
	}
	
	@Test
	void testAlterarQuantidade() {
		ItemQI item1 = new ItemQI("Pepero Biscoito de Palito de Chocolate", "alimento industrializado", 1, 6, "4");
		Compra compra4 = new Compra(2, item1);
		compra4.setQuantidade(5);
		assertEquals(5, compra4.getQuantidade());
	}
	
	@Test
	void testGetItem() {
		ItemQuilo item3 = new ItemQuilo("limao taiti", "alimento nao industrializado", 2.0, 3);
		Compra compra = new Compra(5, item3);
		assertEquals("3. limao taiti, alimento nao industrializado, Preco por quilo: <>", compra.getItem());
	}
	
	@Test
	void testToString() {
		ItemQuilo item3 = new ItemQuilo("limao", "alimento nao industrializado", 2.0, 3);
		Compra compra1 = new Compra(5, item3);
		assertEquals("5 limao, alimento nao industrializado", compra1.toString());
	}
	
}
