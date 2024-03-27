package com.example.lib;

import com.example.framework.Framework;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FrameworkTest {

	@Test
	public void testFramework() {
		Framework subject = Framework.instance();
		assertNotNull(subject);

		assertEquals(0, subject.size());
		subject.register(Runnable.class, () -> System.out.println("tested runnable"));
		assertEquals(1, subject.size());
		assertEquals(Runnable.class, subject.getRegisteredServices().iterator().next());
		Optional<Runnable> service = subject.getService(Runnable.class);
		assertNotNull(service);
		assertTrue(service.isPresent());
		service.get().run();
	}
}
