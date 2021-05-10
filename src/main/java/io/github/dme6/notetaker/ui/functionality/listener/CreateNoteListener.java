package io.github.dme6.notetaker.ui.functionality.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.task.ReadNotesTask;
import io.github.dme6.notetaker.task.SaveNoteTask;
import io.github.dme6.notetaker.ui.MainPanel;

public class CreateNoteListener implements ActionListener {

	private MainPanel mp;
	
	public CreateNoteListener(MainPanel mp) {
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		@SuppressWarnings("unchecked")
		SaveNoteTask snTask = new SaveNoteTask
			(new NoteData("Title", "# Hello."), cb -> {

			if(cb.getStatus() == 0) {
				new Thread(new ReadNotesTask(cb2 -> {
					mp.refreshNotes((List<NoteData>) cb2.getData());
				})).start();
			}
			
		});
		
		new Thread(snTask).start();
		
	}

}
