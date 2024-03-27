package com.example.lib.token.impl;

import com.example.framework.Bootstrapper;
import com.example.framework.Framework;
import com.example.lib.token.Tokeniser;

import java.util.Arrays;
import java.util.stream.Stream;

public class TokeniserImpl implements Tokeniser, Bootstrapper {

	@Override
	public void init(Framework f) {
		f.register(Tokeniser.class, new TokeniserImpl());
	}

	@Override
	public Stream<String> tokenise(String s) {
		return Arrays.stream(s.split(" "));
	}
}
