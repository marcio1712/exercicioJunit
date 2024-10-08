package carrinho;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto livro1;
    private Produto livro2;
    private Produto livro3;

    @Before
    public void setUp() {
        carrinho = new Carrinho();
        livro1 = new Produto("livro A", 100.00);
        livro2 = new Produto("livro B", 150.00);
        livro3 = new Produto("livro C", 180.00);
    }

    @DisplayName ("Teste para adicionar um item ao carrinho")
    @Test
    public void testAddItem() {
        carrinho.addItem(livro1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(100.00, carrinho.getValorTotal(), 0.01);
    }

    @DisplayName("Teste para calcular o valor total do carrinho") 
    @Test
    public void testGetValorTotal() {
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        carrinho.addItem(livro3);

        assertEquals(3, carrinho.getQtdeItems());
        assertEquals(430.00, carrinho.getValorTotal(), 0.01); // 100 + 150 + 180
    }

    @DisplayName("Teste para remover um item do carrinho") 
    @Test
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        carrinho.removeItem(livro1);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(150.00, carrinho.getValorTotal(), 0.01); // apenas o livro2 permanece
    }

    @DisplayName("Teste para exceção ao tentar remover um produto que não está no carrinho") 
    @Test(expected = ProdutoNaoEncontradoException.class)
    public void testRemoveItemNaoEncontrado() throws ProdutoNaoEncontradoException {
        carrinho.addItem(livro1);
        carrinho.removeItem(livro2); // livro2 não está no carrinho, deve lançar exceção
    }

    @DisplayName ("Teste para esvaziar o carrinho")
    @Test
    public void testEsvazia() {
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        carrinho.addItem(livro3);
        
        carrinho.esvazia();
        
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.01);
    }
}
