package codingBat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class logic2Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLoneSum123() {
		int expected = 6;
		int actual = logic2.loneSum(1, 2, 3);
		assertEquals(expected, actual);
	}

	@Test
	void testLoneSum323() {
		int expected = 2;
		int actual = logic2.loneSum(3, 2, 3);
		assertEquals(expected, actual);
	}

	@Test
	void testLoneSum333() {
	int expected = 0;
	int actual = logic2.loneSum(3, 3, 3);
	assertEquals(expected, actual);
	}

	@Test
	void testLoneSum922() {
	int expected = 9;
	int actual = logic2.loneSum(9, 2, 2);
	assertEquals(expected, actual);
	}

	@Test
	void testLoneSum229() {
	int expected = 9;
	int actual = logic2.loneSum(2, 2, 9);
	assertEquals(expected, actual);
	}

	@Test
	void testLoneSum292() {
	int expected = 9;
	int actual = logic2.loneSum(2, 9, 2);
	assertEquals(expected, actual);
	}

	@Test
	void testLoneSum293() {
	int expected = 14;
	int actual = logic2.loneSum(2, 9, 3);
	assertEquals(expected, actual);
	}

	@Test
	void testLoneSum423() {
	int expected = 9;
	int actual = logic2.loneSum(4, 2, 3);
	assertEquals(expected, actual);
	}

	@Test
	void testLoneSum131() {
	int expected = 3;
	int actual = logic2.loneSum(1, 3, 1);
	assertEquals(expected, actual);
	}
}
