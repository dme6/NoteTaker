package io.github.dme6.notetaker.ui.subcomponent;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class NTLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NTLabel() {
		
		super("NoteTaker", JLabel.CENTER);
		
		this.setOpaque(true);
		this.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.setBorder(new EmptyBorder(0, 10, 0, 10));
		this.setBackground(new Color(140, 157, 184));
		
	}

}
