package calculadora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("Classe de Testes Unitários da Calculadora (versão expandida)")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeAll
    @DisplayName("Início da suíte de testes")
    public static void antesDeTodos() {
        System.out.println("Iniciando testes...");
    }

    @AfterAll
    @DisplayName("Fim da suíte de testes")
    public static void depoisDeTodos() {
        System.out.println("Finalizando testes...");
    }

    @BeforeEach
    @DisplayName("Instancia uma calculadora para cada teste")
    public void inicializa() {
        calc = new Calculadora();
    }

    // ===================== SOMA =====================
    @Test
    @DisplayName("Soma de dois números positivos")
    void testSomaPositivos() {
        assertEquals(9, calc.soma(4, 5));
    }

    @Test
    @DisplayName("Soma envolvendo zero")
    void testSomaComZero() {
        assertEquals(7, calc.soma(7, 0));
        assertEquals(-3, calc.soma(-3, 0));
    }

    @Test
    @DisplayName("Soma com números negativos")
    void testSomaComNegativos() {
        assertEquals(-8, calc.soma(-3, -5));
        assertEquals(2, calc.soma(-3, 5));
    }

    @Test
    @DisplayName("Soma com overflow")
    void testSomaComOverflow() {
        assertEquals(Integer.MIN_VALUE, calc.soma(Integer.MAX_VALUE, 1));
    }

    // ===================== SUBTRAÇÃO =====================
    @Test
    @DisplayName("Subtração de dois números")
    void testSubtracaoNormal() {
        assertEquals(5, calc.subtracao(10, 5));
    }

    @Test
    @DisplayName("Subtração envolvendo zero")
    void testSubtracaoComZero() {
        assertEquals(10, calc.subtracao(10, 0));
        assertEquals(-10, calc.subtracao(0, 10));
    }

    @Test
    @DisplayName("Subtração com negativos")
    void testSubtracaoComNegativos() {
        assertEquals(-2, calc.subtracao(-5, -3));
        assertEquals(-8, calc.subtracao(-5, 3));
    }

    @Test
    @DisplayName("Subtração com underflow")
    void testSubtracaoComUnderflow() {
        assertEquals(Integer.MAX_VALUE, calc.subtracao(Integer.MIN_VALUE, 1));
    }

    // ===================== MULTIPLICAÇÃO =====================
    @Test
    @DisplayName("Multiplicação de dois números")
    void testMultiplicacaoNormal() {
        assertEquals(50, calc.multiplicacao(10, 5));
    }

    @Test
    @DisplayName("Multiplicação por zero")
    void testMultiplicacaoPorZero() {
        assertEquals(0, calc.multiplicacao(10, 0));
        assertEquals(0, calc.multiplicacao(0, -5));
    }

    @Test
    @DisplayName("Multiplicação com sinais diferentes")
    void testMultiplicacaoSinais() {
        assertEquals(-15, calc.multiplicacao(-3, 5));
        assertEquals(15, calc.multiplicacao(-3, -5));
    }

    @Test
    @DisplayName("Multiplicação com overflow")
    void testMultiplicacaoComOverflow() {
        assertEquals(-10, calc.multiplicacao(Integer.MAX_VALUE, 10));
    }

    // ===================== DIVISÃO =====================
    @Test
    @DisplayName("Divisão normal")
    void testDivisaoNormal() {
        assertEquals(2, calc.divisao(8, 4));
    }

    @Test
    @DisplayName("Divisão com truncamento (não exata)")
    void testDivisaoComTruncamento() {
        assertEquals(3, calc.divisao(7, 2));  // resultado real = 3.5 → truncado para 3
        assertEquals(-3, calc.divisao(-7, 2)); // resultado real = -3.5 → truncado para -3
    }

    @Test
    @DisplayName("Divisão com sinais diferentes")
    void testDivisaoSinais() {
        assertEquals(-2, calc.divisao(10, -5));
        assertEquals(2, calc.divisao(-10, -5));
    }

    @Test
    @DisplayName("Divisão por zero lança exceção")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.divisao(8, 0));
    }

    // ===================== SOMATÓRIA =====================
    @Test
    @DisplayName("Somatória de número positivo")
    void testSomatoriaPositiva() {
        assertEquals(15, calc.somatoria(5)); // 5+4+3+2+1+0 = 15
    }

    @Test
    @DisplayName("Somatória de zero")
    void testSomatoriaZero() {
        assertEquals(0, calc.somatoria(0));
    }

    @Test
    @DisplayName("Somatória de número negativo deve retornar 0 (loop não executa)")
    void testSomatoriaNegativa() {
        assertEquals(0, calc.somatoria(-5));
    }

    // ===================== EH POSITIVO =====================
    @Test
    @DisplayName("Verifica se número é positivo, negativo ou zero")
    void testEhPositivo() {
        assertTrue(calc.ehPositivo(5));
        assertTrue(calc.ehPositivo(0));
        assertFalse(calc.ehPositivo(-5));
    }

    // ===================== COMPARA =====================
    @Test
    @DisplayName("Comparação entre números")
    void testCompararDoisNumeros() {
        assertEquals(1, calc.compara(5, 3));   // a > b
        assertEquals(-1, calc.compara(3, 5));  // a < b
        assertEquals(0, calc.compara(5, 5));   // a == b
    }

    @Test
    @DisplayName("Comparação com valores extremos")
    void testCompararLimites() {
        assertEquals(-1, calc.compara(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(1, calc.compara(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
