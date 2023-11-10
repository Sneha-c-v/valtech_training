package com.valtech.training.day2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.valtech.training.day2.Arithmetic1;
import com.valtech.training.day2.Arithmeticimpl;
import com.valtech.training.day2.dividebyzeroexception;

class Arithmetic1Test {
	private Arithmetic1 arithmetic = new Arithmeticimpl();

	@BeforeAll
	static void beforeAll() {
		System.out.println("Before all....");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After All.....");
	}

	@BeforeEach
	void anything() {
		System.out.println("Init.......");
		arithmetic = new Arithmeticimpl();
	}

	@AfterEach
	void anything1() {
		System.out.println("Destroyed........");

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("To check if the +ve nos and -ve nos are added correctly")
	void testAdd() {
		assertEquals(5, arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, 2));
		assertEquals(5, arithmetic.add(5, 0));
		assertEquals(-5, arithmetic.add(-5, -0));
		assertEquals(-5, arithmetic.add(-8, 3));
	}

	@Test
	void testSub() {
	}

	@Test
	void testDivByZero() {

		assertThrows(dividebyzeroexception.class, () -> arithmetic.div(5, 0));

	}

	@Test
	void testMul() {
	}

	static Stream<Arguments> addArgsGenerator() {
		return Stream.of(Arguments.of(1, 2, 3), Arguments.of(-1, -2, -3), Arguments.of(1, -2, -1));
	}

	@ParameterizedTest(name = "Add with CSV  file{0}+{1}={2}")
	@CsvFileSource(files = { "add.csv" })
	void testWithCSVFile(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));
	}

	@ParameterizedTest(name = "Add with method {0}+{1}={2}")
	@MethodSource(value = { "addArgsGenerator" })
	void testWithMethod(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));
	}

	@ParameterizedTest(name = "Add with CSV {0}+{1}={2}")
	@CsvSource(value = { "2,3,5", "-2,3,1", "-1,-3,-4" })
	void testWithCSVParams(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));
	}

	@ParameterizedTest(name = "Add with {0}")
	@ValueSource(strings = { "2,3,5", "-2,3,1", "-1,-3,-4" })
	void testAddWithParams(String value) {
		String[] parts = value.split(",");
		List<Integer> values = Arrays.asList(parts).stream().map(it -> Integer.parseInt(it))
				.collect(Collectors.toList());
		assertEquals(values.get(2), arithmetic.add(values.get(0), values.get(1)));
	}

	@Test
	void testDiv() throws dividebyzeroexception {
		assertEquals(1.666, 5.0 / 3, 0.001, "Value is not in range");
		assertEquals(2, arithmetic.div(4, 2));
		assertEquals(2, arithmetic.div(-6, -3));
		try {
			assertEquals(2, arithmetic.div(4, 0));
			fail("Should have throws ArithmeticException");

		} catch (dividebyzeroexception ex) {

		}

	}
}
