package io.github.dme6.notetaker.ui.subcomponent;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.ui.MainPanel;
import io.github.dme6.notetaker.ui.functionality.DeleteNoteListener;
import io.github.dme6.notetaker.ui.functionality.RenameNoteListener;
import io.github.dme6.notetaker.ui.functionality.SaveNoteListener;
import net.miginfocom.swing.MigLayout;

public class Sidebar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainPanel mp;
	
	public Sidebar(MainPanel mp) {
		
		this.mp = mp;
		this.setLayout(new MigLayout());
		this.setBorder(new LineBorder(Color.GRAY, 1));
		this.setBackground(new Color(161, 177, 204));
		
	}
	
	public void init(NoteData nd) {
		
		this.removeAll();
		
		JButton renNote = new JButton("Rename");
		JButton saveNote = new JButton("Save");
		JButton delNote = new JButton("Delete");
		
		renNote.addActionListener(new RenameNoteListener(mp, nd));
		delNote.addActionListener(new DeleteNoteListener(mp, nd));
		saveNote.addActionListener(new SaveNoteListener(mp, nd));
		
		this.add(renNote, "pushx, growx, wrap");
		this.add(saveNote, "pushx, growx, wrap");
		this.add(delNote, "pushx, growx");
		
		this.revalidate();
		this.repaint();
		
	}
	
	public void unInit() {
		
		this.removeAll();
		this.revalidate();
		this.repaint();
		
	}

}
