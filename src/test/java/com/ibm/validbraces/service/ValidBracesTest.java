package com.ibm.validbraces.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidBracesTest {

	@Autowired
	ValidBracesService validBracesService;

	@Test
	void validateEmptyString() {
		assertFalse(validBracesService.notAnEmptyString(""));
	}

	@Test
	void validateValidCharacters() {
		assertFalse(validBracesService.areValidBraces("{}(x)[]"));
		assertFalse(validBracesService.areValidBraces("asas"));
		assertTrue(validBracesService.areValidBraces("{}()[]"));
	}

	@Test
	void validateEvenCharacters() {
		assertFalse(validBracesService.evenBraces("{"));
		assertFalse(validBracesService.evenBraces("{]]"));
		assertTrue(validBracesService.evenBraces("{}"));
	}

	@Test
	void validateFirstBraceIsOpenBrace() {
		assertFalse(validBracesService.isInitialBraceOpen("}{"));
		assertTrue(validBracesService.isInitialBraceOpen("{}"));
	}

	@Test
	void validateCloseBraceHasItsOpenBrace() {
		assertEquals('{', validBracesService.getOpenBrace('}'));
		assertEquals('(', validBracesService.getOpenBrace(')'));
		assertNotEquals('{', validBracesService.getOpenBrace(')'));
		assertEquals(' ', validBracesService.getOpenBrace('x'));
	}

	@Test
	void validateBracesHasTheCorrectSyntax() {
		assertFalse(validBracesService.validate(""));
		assertTrue(validBracesService.validate("(){}[]"));
		assertTrue(validBracesService.validate("([{}])"));
		assertFalse(validBracesService.validate("(}"));
		assertFalse(validBracesService.validate("[(])"));
		assertFalse(validBracesService.validate("[({})](]"));
		assertFalse(validBracesService.validate("{"));
		assertFalse(validBracesService.validate("(])"));
		assertFalse(validBracesService.validate("}}"));
	}

}
