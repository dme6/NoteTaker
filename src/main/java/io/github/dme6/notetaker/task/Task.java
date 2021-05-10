package io.github.dme6.notetaker.task;

import javax.swing.SwingUtilities;

import io.github.dme6.notetaker.data.CallbackData;

public abstract class Task implements Runnable {

	private Callback cb;
	
	protected Task(Callback cb) {
		this.cb = cb;
	}
	
	protected void callBackEDT(CallbackData cbData) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				cb.callback(cbData);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
