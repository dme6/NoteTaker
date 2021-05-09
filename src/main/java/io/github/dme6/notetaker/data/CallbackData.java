package io.github.dme6.notetaker.data;

// TODO: Add a list to keep track of multiple objects.

public class CallbackData {

	private int status;
	private Object data;
	
	public CallbackData(int status, Object data) {
		this.status = status;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

}
