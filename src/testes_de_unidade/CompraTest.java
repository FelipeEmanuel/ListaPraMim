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

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//ItemQI item1 = new ItemQI("Pepero Biscoito de Palito de Chocolate", "alimento industrializado", 1, 6, "4");
		//ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		//ItemQuilo item3 = new ItemQuilo("limao", "alimento nao industrializado", 2.0, 3);
	}

	@Test
	void testCompra() {
		ItemQuilo item3 = new ItemQuilo("limao", "alimento nao industrializado", 2.0, 3);
		Compra compra1 = new Compra(5, item3);
		assertEquals(5, compra1.getQuantidade());
		ItemUnidade item2 = new ItemUnidade("toalha de banho", "higiene pessoal", 2, 2);
		Compra compra2 = new Compra(2, item2);
		assertEquals(2, compra2.getQuantidade());
	}
}
