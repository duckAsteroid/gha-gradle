package com.example.lib.token.impl;

import com.example.lib.token.impl.TokeniserImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokeniserImplTest {

	@Test
	public void testTokeniser() {
		TokeniserImpl subject = new TokeniserImpl();
		List<String> actual = subject.tokenise("This is MixedCase").toList();
		assertNotNull(actual);
		assertEquals(3, actual.size());
		assertEquals("This", actual.get(0));
		assertEquals("is", actual.get(1));
		assertEquals("MixedCase", actual.get(2));
	}
}
