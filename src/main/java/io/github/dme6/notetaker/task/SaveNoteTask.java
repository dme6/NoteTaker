package io.github.dme6.notetaker.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.data.NoteData;

public class SaveNoteTask extends Task {

	private NoteData nd;
	
	public SaveNoteTask(NoteData nd, Callback cb) {
		super(cb);
		this.nd = nd;
	}

	@Override
	public void run() {	
		
		NoteData newN = new NoteData(nd);
		
		File dataFolder = new File("./data_notetaker");
		if(!dataFolder.exists()) {
			dataFolder.mkdirs();
		}
		
		Random randGen = new Random();
		int noteId;
		
		if(newN.getNoteId() == 0) {
			noteId = randGen.nextInt(1000000000);
			newN.setNoteId(noteId);
		} else {
			noteId = newN.getNoteId();
		}
		
		try {
			
			ObjectOutputStream os = new ObjectOutputStream
					(new FileOutputStream(dataFolder.getAbsolutePath() + "/" + noteId + ".dat"));
			
			os.writeObject(newN);		
			os.close();
			
			this.callBackEDT(new CallbackData(0, ""));
			
		} catch(Exception e) {
			this.callBackEDT(new CallbackData(1, ""));
		}
		
	}

}
