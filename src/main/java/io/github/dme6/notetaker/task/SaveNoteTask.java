package io.github.dme6.notetaker.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.data.NoteData;

public class SaveNoteTask implements Runnable {

	private NoteData nd;
	private Callback cb;
	
	public SaveNoteTask(NoteData nd, Callback cb) {
		this.nd = nd;
		this.cb = cb;
	}

	@Override
	public void run() {	
		
		try {
			
			File dataFolder = new File("./data_notetaker");
			if(!dataFolder.exists()) {
				dataFolder.mkdirs();
			}
			
			Random randGen = new Random();
			int noteId;
			
			if(nd.getNoteId() == 0) {
				noteId = randGen.nextInt(1000000000);
		        nd.setNoteId(noteId);
			} else {
				noteId = nd.getNoteId();
			}
			
			ObjectOutputStream os = new ObjectOutputStream
					(new FileOutputStream(dataFolder.getAbsolutePath() + "/" + noteId + ".dat"));
			
			os.writeObject(nd);		
			os.close();
			
			cb.callback(new CallbackData(0, ""));
			
		} catch(Exception e) {
			e.printStackTrace();
			cb.callback(new CallbackData(1, ""));
		}
		
	}

}
