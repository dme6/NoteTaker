package io.github.dme6.notetaker.ui.functionality.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.task.DeleteNoteTask;
import io.github.dme6.notetaker.task.ReadNotesTask;
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
				new Thread(new ReadNotesTask(cb2 -> {
					mp.refreshNotes((List<NoteData>) cb2.getData());
				})).start();
			}	
		});
		
		new Thread(dnTask).start();
		
	}

}
