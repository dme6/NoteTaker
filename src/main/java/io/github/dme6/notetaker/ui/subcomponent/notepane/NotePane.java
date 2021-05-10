package io.github.dme6.notetaker.ui.subcomponent.notepane;

import javax.swing.JTabbedPane;

public class NotePane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NoteViewer viewer;
	private NoteEditor editor;

	public NotePane() {
		init();
	}
	
	private void init() {
		
		editor = new NoteEditor();
		this.add("Editor", new TabScroll(editor));
		
		viewer = new NoteViewer();
		this.add("Viewer", new TabScroll(viewer));
		
	}

	public NoteViewer getViewer() {
		return viewer;
	}

	public NoteEditor getEditor() {
		return editor;
	}

}
