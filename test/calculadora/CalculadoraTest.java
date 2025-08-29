package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeAll
	@DisplayName("Começar o teste")
	public static void antesDeTodos() {
		System.out.println("Iniciando testes...");
	}

	@AfterAll
	@DisplayName("Finalizar o teste")
	public static void depoisDeTodos() {
		System.out.println("Finalizando testes...");
	}

	@BeforeEach
	@DisplayName("Instancia uma calculadora para cada teste")
	public void inicializa() {
		calc = new Calculadora();
	}
	
	
	@Test
	@DisplayName("Testa a soma de dois números")
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}

	
	@Test
	@DisplayName("Testa a soma no limite max para a variavel int")
	public void testSomaComOverflow(){
		int soma = calc.soma(Integer.MAX_VALUE, 1);
		Assertions.assertEquals(soma, Integer.MIN_VALUE);
	}

	@Test
	@DisplayName("Testa a subtracao de dois numeros")
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(10, 5);
		assertTrue(subtracao == 5);
	}

	@Test
	@DisplayName("Testa a subtracao no limite min para a variavel int")
	public void testSubtracaoComUnderflow(){
		int soma = calc.subtracao(Integer.MIN_VALUE, 1);
		Assertions.assertEquals(soma, Integer.MAX_VALUE);
	}

	@Test
	@DisplayName("Testa a multiplicacao de dois numeros")
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(10, 5);
		Assertions.assertEquals(50, multiplicacao);
	}

	@Test
	@DisplayName("Testa a multiplicacao no limite max para a variavel int")
	public void testMultiplicacaoComOverflow(){
		int multiplicacao = calc.multiplicacao(Integer.MAX_VALUE, 10);
		Assertions.assertEquals(-10, multiplicacao);
	}

	@Test
	@DisplayName("Testa o somatorio de 0 até n")
	public void testSomatorio() {
		int somatorio = calc.somatoria(5);
		assertEquals(15, somatorio);
	}

	@Test
	@DisplayName("Testa se um numero é positivo")
	public void testEhPositivo() {
		assertTrue(calc.ehPositivo(5));
		assertTrue(!calc.ehPositivo(-5));
		assertTrue(calc.ehPositivo(0));
	}
	
	@Test
	@DisplayName("Testa a comparacao entre dois numeros")
	public void testCompararDoisNumeros() {
		assertTrue(calc.compara(5, 3) > 0);
		assertTrue(calc.compara(3, 5) < 0);
		assertTrue(calc.compara(5, 5) == 0);
	}

	@Test
	@DisplayName("Testa a divisao de dois numeros")
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	@DisplayName("Testa a divisao por zero")
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	@DisplayName("Testa a divisao por zero com assertThrows")
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
