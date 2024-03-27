package com.example.framework;

import java.util.*;

public class Framework {
	private static final Framework SINGLETON = new Framework();

	public static Framework instance() {
		return SINGLETON;
	}

	private final HashMap<Class<?>, Object> registry = new HashMap<>();

	private Framework() {
		ServiceLoader<Bootstrapper> loader = ServiceLoader.load(Bootstrapper.class);
		loader.stream()
						.map(ServiceLoader.Provider::get)
						.filter(Objects::nonNull)
						.forEach(bootstrapper -> bootstrapper.init(this));
	}

	public Framework(Bootstrapper ... bootstrappers) {
		for(Bootstrapper bs : bootstrappers) {
			bs.init(this);
		}
	}

	public <T> Optional<T> getService(Class<T> clazz) {
		return Optional.ofNullable((T) registry.get(clazz));
	}

	public Set<Class<?>> getRegisteredServices() {
		return Collections.unmodifiableSet(registry.keySet());
	}

	public int size() {
		return registry.size();
	}

	public <T> void register(Class<T> clazz, T instance) {
		if (instance != null && clazz != null) {
			registry.put(clazz, instance);
		}
	}

	public void printRegistry() {
		registry.entrySet().stream()
						.map(entry -> entry.getKey().getName() + "="+entry.getValue().toString())
						.forEach(System.out::println);
	}
}
