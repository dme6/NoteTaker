package io.github.dme6.notetaker.task;

public class DelayTask extends Task {
	
	private int delay;
	
	public DelayTask(int delay, Callback cb) {
		super(cb);
		this.delay = delay;
	}

	@Override
	public void run() {
		
		try {
			
			Thread.sleep(delay);
			this.callBackEDT(null);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
