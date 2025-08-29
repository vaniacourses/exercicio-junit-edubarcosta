package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.*;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdução ao Teste de Software", 100.00);
	}
	
	@Test
	public void testCriaProduto() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdução ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco())						
				);
	}
	
	@Test
	public void testProdutosDiferentesPeloPreço() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		assertNotSame(livro, livro2);
	}

	@Test
	public void testProdutosDiferentesPeloNome() {
		Produto livro2 = new Produto("Introdução ao Teste de Sistema", 100.00);
		assertNotSame(livro, livro2);
	}
	
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 100.00);
		assertNotSame(livro, livro2);
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(livro.getPreco(), equalTo(100.00));
		assertThat(livro.getNome(), notNullValue());
		assertThat(livro.getNome(), containsString("Teste"));
		assertThat(livro, instanceOf(Produto.class));
	}

	@Test
	public void testAlterarNome(){
		livro.setNome("O Homem que calculava");
		Assertions.assertEquals("O Homem que calculava", livro.getNome());
	}

	@Test
	public void testAlterarPreco(){
		livro.setPreco(55.50);
		Assertions.assertTrue(livro.getPreco() == 55.50);
	}

}
