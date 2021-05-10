package io.github.dme6.notetaker.task;

import java.io.File;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.data.NoteData;

public class DeleteNoteTask extends Task {
	
	private NoteData nd;
	
	public DeleteNoteTask(NoteData nd, Callback cb) {
		super(cb);
		this.nd = nd;
	}

	@Override
	public void run() {
		
		File file = new File("./data_notetaker/" + nd.getNoteId() + ".dat");
		
		if(file.delete()) {
			this.callBackEDT(new CallbackData(0, ""));
		} else {
			this.callBackEDT(new CallbackData(1, ""));
		}
		
	}

}
