package io.github.dme6.notetaker.ui.functionality.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.prompt.RenamePrompt;
import io.github.dme6.notetaker.task.Callback;
import io.github.dme6.notetaker.task.ReadNotesTask;
import io.github.dme6.notetaker.task.SaveNoteTask;
import io.github.dme6.notetaker.ui.MainPanel;

public class RenameNoteListener implements ActionListener {

	private MainPanel mp;
	private NoteData nd;
	
	public RenameNoteListener(MainPanel mp, NoteData nd) {
		this.mp = mp;
		this.nd = nd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		NoteData newN = new NoteData(nd);
		
		@SuppressWarnings("unchecked")
		Callback snCb = cb -> {
			mp.refreshNotes((List<NoteData>) cb.getData());
			mp.openNote(newN);
		};
		
		new RenamePrompt(cb -> {
			
			newN.setTitle((String) cb.getData());
			
			SaveNoteTask snTask = new SaveNoteTask(newN, cb2 -> {
				if(cb2.getStatus() == 0) {
					new Thread(new ReadNotesTask(snCb)).start();
				}
			});
			
			new Thread(snTask).start();
			
		});
		
	}
	
}
