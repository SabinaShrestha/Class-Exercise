package resursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacorialTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testIterativeFactorial_3() {
		long expected = 6;
		long actual = Factorial.iterativeFactorial(3); //call the method we are testing
		assertEquals(expected, actual);      //expected first, actual second
	}
	
	@Test
	void testIterativFactorial_negative() {
		assertThrows(IllegalArgumentException.class, () -> {
			Factorial.iterativeFactorial(-1);
		});
	}
	
	@Test
	void testRecursiveFactorial_negative() {
		assertThrows(IllegalArgumentException.class, () -> {
			Factorial.recursiveFactorial(-1);
		});
	}
	
	@Test
	void testIterativeFactorial_1() {
		assertEquals(1, Factorial.iterativeFactorial(1));
	}
	
	@Test
	void testIterativeFactorial_0() {
		assertEquals(1, Factorial.iterativeFactorial(0));
	}
	
//	@Test
//	void testIterativeFactorial_minus1() {
//		assertEquals(Illegal, Factorial.iterativeFactorial(-1));
//	}



	@Test
	void testRecursiveFactorial_3() {
		assertEquals(6, Factorial.recursiveFactorial(3));
	}

}
