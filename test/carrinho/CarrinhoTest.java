package carrinho;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.*;

public class CarrinhoTest {
    Carrinho carrinho;
    Produto produto1;
    Produto produto2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        produto1 = new Produto("Produto 1", 10.0);
        produto2 = new Produto("Produto 2", 20.0);
    }

    @Test
    public void testAddItem() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(10.0, carrinho.getValorTotal());
    }

    @Test
    public void testValorTotal() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(30.0, carrinho.getValorTotal());
    }

    @Test 
    public void testEsvaziaEGetQtdeItems(){
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(carrinho.getQtdeItems(), 2);
        carrinho.esvazia();
        assertEquals(carrinho.getQtdeItems(), 0);
    }

    @Test
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems());
        carrinho.removeItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(20.0, carrinho.getValorTotal());
    }



}
