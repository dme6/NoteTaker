package io.github.dme6.notetaker.ui.functionality.other;

import io.github.dme6.notetaker.task.Callback;

public class SimpleDelay implements Runnable {

	private Callback cb;
	private int delay;
	
	public SimpleDelay(int delay, Callback cb) {
		this.cb = cb;
		this.delay = delay;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cb.callback(null);
		
	}

}
