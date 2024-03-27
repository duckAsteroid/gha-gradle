package com.example.lib.token;

import java.util.stream.Stream;

public interface Tokeniser {
	Stream<String> tokenise(String s);
}
