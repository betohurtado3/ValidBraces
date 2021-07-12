package com.ibm.validbraces.service;

import java.util.ArrayDeque;
import java.util.Deque;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ValidBracesService {

	String validChars = "{}[]()";
	String validInitialBraces = "{[(";

	public boolean notAnEmptyString(String string) {
		return StringUtils.hasLength(string);
	}

	public boolean evenBraces(String string) {
		return string.length() % 2 == 0;
	}

	public boolean areValidBraces(String string) {
		for (String brace : string.split("")) {
			if (!validChars.contains(brace)) {
				return false;
			}
		}
		return true;
	}

	public boolean isInitialBraceOpen(String string) {
		return validInitialBraces.contains(String.valueOf(string.charAt(0)));
	}

	public char getOpenBrace(char brace) {
		var result = ' ';
		switch (brace) {
		case '}':
			result = '{';
			break;
		case ')':
			result = '(';
			break;
		case ']':
			result = '[';
			break;
		default:
			break;
		}
		return result;
	}

	public boolean validate(String braces) {
		Deque<Character> lifo = new ArrayDeque<>();
		if (notAnEmptyString(braces) && evenBraces(braces) && isInitialBraceOpen(braces)) {
			for (var i = 0; i < braces.length(); i++) {
				if (isInitialBraceOpen(String.valueOf(braces.charAt(i)))) {
					lifo.push(braces.charAt(i));
				} else if (lifo.peek() == getOpenBrace(braces.charAt(i))) {
					lifo.pop();
				}
			}
		} else {
			return false;
		}
		return lifo.isEmpty();
	}

}
