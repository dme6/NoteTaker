package io.github.dme6.notetaker.data;

import java.io.Serializable;

public class NoteData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String body;
	private int noteId;
	
	public NoteData(String title, String body) {
		this.title = title;
		this.body = body;
	}
	
	public NoteData(NoteData nd) {
		this(nd.getTitle(), nd.getBody());
		setNoteId(nd.getNoteId());	
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

	public int getNoteId() {
		return noteId;
	}
	
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

}
