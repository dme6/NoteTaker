package io.github.dme6.notetaker.ui.subcomponent.notepane;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class NoteViewer extends JTextPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoteViewer() {
		this.setContentType("text/html");
		this.setEditable(false);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}
