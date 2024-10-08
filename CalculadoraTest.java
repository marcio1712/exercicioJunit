package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	@DisplayName("Testa a multiplicação de 2 numeros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplica = calc.multiplicacao(7, 7);		
		Assertions.assertEquals(49, multiplica);		
	}
	@DisplayName("Testa a se o numero eh positivo")
	@Test
	public void testNumeroPositivo() {
		boolean positivo = calc.ehPositivo(10);		
		Assertions.assertTrue(positivo);
	}

	@DisplayName("Testa se dois numeros sao iguais")
	@Test
	public void testComparacaoDoisNumeros() {
		int comparador = calc.compara(5, 5);		
		Assertions.assertEquals(0, comparador);	
	}	
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
