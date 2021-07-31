package com.mx.shopsrus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.shopsrus.tools.Operations;

@SpringBootTest
class OperationsTest {
	
	
	@Test
	void testCalculaAntiguedad() {
		int expected  = 2;		
		int actual = Operations.calculaAntiguedad("2019-07-31");
		
		assertEquals(expected, actual);
		
	}

	
	@Test
	void testPruebaCast() {
		Double expected  = 2.0;		
		Double actual = Operations.TryParseDouble("2");
		
		assertEquals(expected, actual);
		
	}

	
}
