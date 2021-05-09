package io.github.dme6.notetaker.task;

import java.io.File;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.data.NoteData;

public class DeleteNoteTask implements Runnable {

	private Callback cb;
	private NoteData nd;
	
	public DeleteNoteTask(NoteData nd, Callback cb) {
		this.cb = cb;
		this.nd = nd;
	}

	@Override
	public void run() {
		
		File file = new File("./data_notetaker/" + nd.getNoteId() + ".dat");
		
		if(file.delete()) {
			cb.callback(new CallbackData(0, ""));
		} else {
			cb.callback(new CallbackData(1, ""));
		}
		
	}

}
