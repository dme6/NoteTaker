package io.github.dme6.notetaker.ui.subcomponent.notepane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class TabScroll extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TabScroll(Component view) {
		this.setBorder(new LineBorder(Color.GRAY, 1));
		this.setViewportView(view);
	}

}
