package io.github.dme6.notetaker.ui.subcomponent;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class NotePane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextPane viewer;
	private JTextArea editor;

	public NotePane() {
		init();
	}
	
	private void init() {
		
		editor = new JTextArea();
		editor.setBorder(new LineBorder(Color.GRAY, 1));
		this.add("Editor", editor);
		
		viewer = new JTextPane();
		viewer.setContentType("text/html");
		viewer.setBorder(new LineBorder(Color.GRAY, 1));
		viewer.setEditable(false);
		this.add("Viewer", viewer);
		
	}

	public JTextPane getViewer() {
		return viewer;
	}

	public JTextArea getEditor() {
		return editor;
	}

}
