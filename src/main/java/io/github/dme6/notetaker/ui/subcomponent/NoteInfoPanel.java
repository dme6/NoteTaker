package io.github.dme6.notetaker.ui.subcomponent;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.ui.MainPanel;
import io.github.dme6.notetaker.ui.functionality.OpenNoteListener;
import net.miginfocom.swing.MigLayout;

public class NoteInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NoteData nd;
	private MainPanel mp;
	
	public NoteInfoPanel(MainPanel mp, NoteData nd) {
		this.mp = mp;
		this.nd = nd;
		this.setLayout(new MigLayout(""));
		this.setBackground(new Color(86, 133, 117));
		init();
	}
	
	private void init() {
		
		this.add(new JLabel(nd.getTitle()), "wrap");
		
		JButton open = new JButton("Open");
		open.addActionListener(new OpenNoteListener(mp, nd));
		this.add(open);
		
	}
	
	public NoteData getNote() {
		return nd;
	}

}
