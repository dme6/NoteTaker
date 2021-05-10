package io.github.dme6.notetaker.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.data.NoteData;

public class ReadNotesTask extends Task {
	
	public ReadNotesTask(Callback cb) {
		super(cb);
	}

	@Override
	public void run() {
		
		File dataFolder = new File("./data_notetaker");
		if(!dataFolder.exists()) {
			dataFolder.mkdirs();
		}
		
		List<NoteData> noteList = new ArrayList<>();
		
		try {
			
			for(File f : dataFolder.listFiles()) {
				ObjectInputStream os = new ObjectInputStream
						(new FileInputStream(f.getAbsolutePath()));
				
				NoteData note = (NoteData) os.readObject();
				noteList.add(note);
				
				os.close();
			}
			
			this.callBackEDT(new CallbackData(0, noteList)); 
			
		} catch(InvalidClassException e) {
			this.callBackEDT(new CallbackData(2, ""));
		} catch(Exception e) {
			this.callBackEDT(new CallbackData(1, ""));
		}
		
	}

}
