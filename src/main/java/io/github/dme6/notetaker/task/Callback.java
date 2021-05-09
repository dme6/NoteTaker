package io.github.dme6.notetaker.task;

import io.github.dme6.notetaker.data.CallbackData;

@FunctionalInterface
public interface Callback {
	public abstract void callback(CallbackData cbData);
}
