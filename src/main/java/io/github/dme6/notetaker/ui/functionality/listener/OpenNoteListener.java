package io.github.dme6.notetaker.ui.functionality.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.ui.MainPanel;

public class OpenNoteListener implements ActionListener {

	private MainPanel mp;
	private NoteData nd;
	
	public OpenNoteListener(MainPanel mp, NoteData nd) {
		this.mp = mp;
		this.nd = nd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mp.openNote(nd);
	}

}
