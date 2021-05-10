package io.github.dme6.notetaker.ui.subcomponent.notepane;

import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class NoteEditor extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoteEditor() {
		this.setEditable(true);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}
