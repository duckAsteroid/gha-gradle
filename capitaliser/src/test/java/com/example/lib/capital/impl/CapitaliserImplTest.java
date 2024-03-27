package com.example.lib.capital.impl;

import com.example.lib.capital.impl.CapitaliserImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitaliserImplTest {

	@Test
	public void testCapitaliser() {
		CapitaliserImpl subject = new CapitaliserImpl();
		String actual = subject.capitalise("This is MixedCase");
		assertEquals("THIS IS MIXEDCASE", actual);
	}
}
