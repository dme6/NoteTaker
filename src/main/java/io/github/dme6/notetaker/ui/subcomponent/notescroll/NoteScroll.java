package io.github.dme6.notetaker.ui.subcomponent.notescroll;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class NoteScroll extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoteScroll(Component view) {		
		this.setBorder(new LineBorder(Color.GRAY, 1));
		this.setMinimumSize(new Dimension(0, 100));	
		this.setViewportView(view);	
	}

}
