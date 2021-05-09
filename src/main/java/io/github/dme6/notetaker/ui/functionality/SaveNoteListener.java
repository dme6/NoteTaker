package io.github.dme6.notetaker.ui.functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.task.SaveNoteTask;
import io.github.dme6.notetaker.ui.MainPanel;

public class SaveNoteListener implements ActionListener {

	private MainPanel mp;
	private NoteData nd;
	
	public SaveNoteListener(MainPanel mp, NoteData nd) {		
		this.mp = mp;
		this.nd = nd;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		NoteData newN = new NoteData(nd);

		newN.setBody(mp.collectData());

		@SuppressWarnings("unchecked")
		SaveNoteTask snTask = new SaveNoteTask(newN, cb -> {
			if(cb.getStatus() == 0) {
				
				mp.updateStatus("Note saved successfully.");
				
				new ReadNotesFunction(cb2 -> {
					mp.refreshNotes((List<NoteData>) cb2.getData());
					mp.openNote(newN);
				}).perform();
				
			}
		});
		
		new Thread(snTask).start();
		
	}

}
