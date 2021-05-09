package io.github.dme6.notetaker.ui.functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.task.DeleteNoteTask;
import io.github.dme6.notetaker.ui.MainPanel;

public class DeleteNoteListener implements ActionListener {

	private MainPanel mp;
	private NoteData nd;
	
	public DeleteNoteListener(MainPanel mp, NoteData nd) {
		this.mp = mp;
		this.nd = nd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		@SuppressWarnings("unchecked")
		DeleteNoteTask dnTask = new DeleteNoteTask(nd, cb -> {		
			if(cb.getStatus() == 0) {
				new ReadNotesFunction(cb2 -> {
					mp.refreshNotes((List<NoteData>) cb2.getData());
				}).perform();
			}	
		});
		
		new Thread(dnTask).start();
		
	}

}
