package io.github.dme6.notetaker.ui.functionality;

import java.util.List;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.task.Callback;
import io.github.dme6.notetaker.task.ReadNotesTask;

public class ReadNotesFunction {

	private Callback cbNotes;
	
	public ReadNotesFunction(Callback cbNotes) {
		this.cbNotes = cbNotes;
	}
	
	public void perform() {
		
		ReadNotesTask rnTask = new ReadNotesTask(cb -> {
			switch(cb.getStatus()) {
			case 0: {
				@SuppressWarnings("unchecked")
				List<NoteData> notes = (List<NoteData>) cb.getData();
				
				cbNotes.callback(new CallbackData(0, notes));	
			}
			
			case 2: {
				
			}
			}
		});
		
		new Thread(rnTask).start();
		
	}

}
