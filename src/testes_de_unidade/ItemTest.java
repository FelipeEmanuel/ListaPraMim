package testes_de_unidade;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entidades.Item;
import entidades.ItemQI;
import entidades.ItemQuilo;
import entidades.ItemUnidade;

class ItemTest {

	@Test
	void testPreco() {
		ItemQI item1 = new ItemQI("Pepero Biscoito de Palito de Chocolate", "alimento industrializado", 1, 6, "4");
		ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		item1.addPreco("Konbini", 6.10);
		item2.addPreco("Extra", 12.10);
		assertEquals(" <Konbini, R$ 6,10;>", item1.getPreco());
		assertEquals(" <Extra, R$ 12,10;>", item2.getPreco());
	}
	
	@Test
	void testGetNome() {
		ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		assertEquals("toalha de banho", item2.getNome());
		ItemQuilo item3 = new ItemQuilo("limao", "alimento nao industrializado", 2.0, 3);
		assertEquals("limao", item3.getNome());
	}
	
	@Test
	void testSetNome() {
		ItemQuilo item3 = new ItemQuilo("limao", "alimento nao industrializado", 2.0, 3);
		item3.setNome("limao taiti");
		assertEquals("limao taiti", item3.getNome());
	}
	
	@Test
	void testCategoria() {
		ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		assertEquals("higiene pessoal", item2.getCategoria());
		item2.setCategoria("higiene");
		assertEquals("higiene", item2.getCategoria());
	}
	
	@Test
	void testToString() {
		ItemQuilo item3 = new ItemQuilo("limao", "alimento nao industrializado", 2.0, 3);
		item3.addPreco("Bem mais", 1.20);
		assertEquals("3. limao, alimento nao industrializado, Preco por quilo: <Bem mais, R$ 1,20;>", item3.toString());
		ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		item2.addPreco("Carrefulvio", 15.50);
		assertEquals("2. toalha de banho, higiene pessoal, Preco: <Carrefulvio, R$ 15,50;>", item2.toString());
		item2.addPreco("Mercado bolando", 13.50);
		assertEquals("2. toalha de banho, higiene pessoal, Preco: <Carrefulvio, R$ 15,50;Mercado bolando, R$ 13,50;>", item2.toString());
	}

}
