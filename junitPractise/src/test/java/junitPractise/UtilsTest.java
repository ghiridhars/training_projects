package junitPractise;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("UnitTest")
class UtilsTest {
	
	Utils mu;
	
	@BeforeEach
	public void initiate() {
		mu = new Utils();
	}
	
//	@Test
//	public void stringTest() {
//		assertNotSame(expected, actual);
//	}

	@Test
	public void SingleTest() {
		int expected = 2;
		int actual = mu.add(1, 1);
		assertEquals(expected, actual);
	}
	
	@RepeatedTest(value=2)
	public void arrayTest() {
		int[] expected = { 2, 4, 6, 8, 10 };
		int[] actual = mu.multiplicationTable(2);
		assertArrayEquals(expected, actual);
	}

	@Nested
	@Tag("NestedTests")
	public class NestedTests{
		@Test
		void oddTest() {
			int actual = mu.add(45, 10);
			assertEquals(1, actual%2);
			assertTrue(actual%2==0);
		}

		@Test
		void areaTest() {
			assertEquals(400, mu.computeArea(10));
		}
	}
	
	@Test
	public void multiTest() {
		assertNotEquals(2, mu.add(1, 1));
		assertEquals(5, mu.sub(6, 1));
		assertEquals(67, mu.mul(4, 6));
		assertEquals(89, mu.div(45, 9));
	}
	
}