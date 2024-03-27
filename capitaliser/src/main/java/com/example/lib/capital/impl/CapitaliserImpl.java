package com.example.lib.capital.impl;

import com.example.framework.Bootstrapper;
import com.example.framework.Framework;
import com.example.lib.capital.Capitaliser;

import java.util.Locale;

public class CapitaliserImpl implements Capitaliser, Bootstrapper {

	@Override
	public void init(Framework f) {
		f.register(Capitaliser.class, new CapitaliserImpl());
	}

	@Override
	public String capitalise(String s) {
		return s.toUpperCase(Locale.ROOT);
	}
}
