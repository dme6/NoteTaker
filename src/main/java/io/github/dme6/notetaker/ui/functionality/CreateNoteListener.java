package io.github.dme6.notetaker.ui.functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import io.github.dme6.notetaker.data.NoteData;
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
				new ReadNotesFunction(cb2 -> {
					mp.refreshNotes((List<NoteData>) cb2.getData());
				}).perform();
			}
			
		});
		
		new Thread(snTask).start();
		
	}

}
