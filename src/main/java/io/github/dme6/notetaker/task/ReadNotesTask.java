package io.github.dme6.notetaker.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.data.NoteData;

public class ReadNotesTask implements Runnable {

	private Callback cb;
	
	public ReadNotesTask(Callback cb) {
		this.cb = cb;
	}

	@Override
	public void run() {
		
		try {
			
			File dataFolder = new File("./data_notetaker");
			if(!dataFolder.exists()) {
				dataFolder.mkdirs();
			}
			
			List<NoteData> noteList = new ArrayList<>();
			
			for(File f : dataFolder.listFiles()) {
				ObjectInputStream os = new ObjectInputStream
						(new FileInputStream(f.getAbsolutePath()));
				
				NoteData note = (NoteData) os.readObject();
				noteList.add(note);
				
				os.close();
			}
			
			cb.callback(new CallbackData(0, noteList)); 
			
		} catch(InvalidClassException e) {
			e.printStackTrace();
			cb.callback(new CallbackData(2, ""));
		} catch(Exception e) {
			e.printStackTrace();
			cb.callback(new CallbackData(1, ""));
		}
		
	}

}
