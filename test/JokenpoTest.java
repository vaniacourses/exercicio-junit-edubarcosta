package jokenpo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokenpoTest {

    private final Jokenpo jokenpo = new Jokenpo();

    @Nested
    @DisplayName("Testes de Empate")
    class EmpateTests {
        @Test
        @DisplayName("Papel vs Papel deve empatar")
        void testEmpatePapel() {
            assertEquals(0, jokenpo.jogar(1, 1));
        }

        @Test
        @DisplayName("Pedra vs Pedra deve empatar")
        void testEmpatePedra() {
            assertEquals(0, jokenpo.jogar(2, 2));
        }

        @Test
        @DisplayName("Tesoura vs Tesoura deve empatar")
        void testEmpateTesoura() {
            assertEquals(0, jokenpo.jogar(3, 3));
        }
    }

    @Nested
    @DisplayName("Vitória do Jogador 1")
    class VitoriaJogador1Tests {
        @Test
        @DisplayName("Papel vence Pedra")
        void testPapelVencePedra() {
            assertEquals(1, jokenpo.jogar(1, 2));
        }

        @Test
        @DisplayName("Pedra vence Tesoura")
        void testPedraVenceTesoura() {
            assertEquals(1, jokenpo.jogar(2, 3));
        }

        @Test
        @DisplayName("Tesoura vence Papel")
        void testTesouraVencePapel() {
            assertEquals(1, jokenpo.jogar(3, 1));
        }
    }

    @Nested
    @DisplayName("Vitória do Jogador 2")
    class VitoriaJogador2Tests {
        @Test
        @DisplayName("Pedra perde para Papel")
        void testPedraPerdeParaPapel() {
            assertEquals(2, jokenpo.jogar(2, 1));
        }

        @Test
        @DisplayName("Tesoura perde para Pedra")
        void testTesouraPerdeParaPedra() {
            assertEquals(2, jokenpo.jogar(3, 2));
        }

        @Test
        @DisplayName("Papel perde para Tesoura")
        void testPapelPerdeParaTesoura() {
            assertEquals(2, jokenpo.jogar(1, 3));
        }
    }

    @Nested
    @DisplayName("Entradas Inválidas")
    class EntradasInvalidasTests {
        @Test
        @DisplayName("Jogador 1 com valor < 1 deve retornar -1")
        void testJogador1ValorMenorQueUm() {
            assertEquals(-1, jokenpo.jogar(0, 2));
        }

        @Test
        @DisplayName("Jogador 1 com valor > 3 deve retornar -1")
        void testJogador1ValorMaiorQueTres() {
            assertEquals(-1, jokenpo.jogar(4, 2));
        }

        @Test
        @DisplayName("Jogador 2 com valor < 1 deve retornar -1")
        void testJogador2ValorMenorQueUm() {
            assertEquals(-1, jokenpo.jogar(2, 0));
        }

        @Test
        @DisplayName("Jogador 2 com valor > 3 deve retornar -1")
        void testJogador2ValorMaiorQueTres() {
            assertEquals(-1, jokenpo.jogar(2, 5));
        }

        @Test
        @DisplayName("Ambos jogadores com valores inválidos deve retornar -1")
        void testAmbosInvalidos() {
            assertEquals(-1, jokenpo.jogar(-1, 10));
        }
    }
}
