package io.github.dme6.notetaker.ui;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import io.github.dme6.notetaker.data.NoteData;
import io.github.dme6.notetaker.ui.functionality.CreateNoteListener;
import io.github.dme6.notetaker.ui.functionality.ReadNotesFunction;
import io.github.dme6.notetaker.ui.functionality.other.SimpleDelay;
import io.github.dme6.notetaker.ui.subcomponent.NTLabel;
import io.github.dme6.notetaker.ui.subcomponent.NoteInfoPanel;
import io.github.dme6.notetaker.ui.subcomponent.NotePane;
import io.github.dme6.notetaker.ui.subcomponent.NoteScroll;
import io.github.dme6.notetaker.ui.subcomponent.NoteScrollPanel;
import io.github.dme6.notetaker.ui.subcomponent.Sidebar;
import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NoteScrollPanel scrlP;
	private NotePane nPane;
	private Sidebar sidebar;
	private JLabel statusLbl;

	@SuppressWarnings("unchecked")
	public MainPanel() {
		this.setLayout(new MigLayout());
		this.setBackground(new Color(200, 200, 200));
		init();
		
		new ReadNotesFunction(cb -> {
			refreshNotes((List<NoteData>) cb.getData());
		}).perform();
	}
	
	private void init() {
		
		NTLabel ntLbl = new NTLabel();
		this.add(ntLbl);
		
		statusLbl = new JLabel("");
		this.add(statusLbl);
		
		JButton createNote = new JButton("Create Note");
		createNote.addActionListener(new CreateNoteListener(this));
		this.add(createNote, "pushx, right, wrap");
		
		scrlP = new NoteScrollPanel();
		NoteScroll nScrl = new NoteScroll(scrlP);	
		this.add(nScrl, "span, growx, wrap");
		
		sidebar = new Sidebar(this);
		
		this.add(sidebar, "grow");
		
		nPane = new NotePane();
		this.add(nPane, "span 2, pushy, grow");
		
	}
	
	public String collectData() {
		return nPane.getEditor().getText();
	}
	
	private Executor exe1 = Executors.newSingleThreadExecutor();
	
	public void updateStatus(String status) {
		statusLbl.setText(status);
		exe1.execute(new SimpleDelay(4000, cb2 -> {
			statusLbl.setText("");
		}));
	}
	
	public void openNote(NoteData nd) {
		
		Parser parser = Parser.builder().build();
		Node doc = parser.parse(nd.getBody());
		HtmlRenderer renderer = HtmlRenderer.builder().build();

		nPane.getEditor().setText(nd.getBody());
		nPane.getViewer().setText(renderer.render(doc));
		sidebar.init(nd);
		
		for(Component comp : scrlP.getComponents()) {
			comp.setBackground(new Color(86, 133, 117));
			NoteInfoPanel np = (NoteInfoPanel) comp;
			if(np.getNote().getNoteId() == nd.getNoteId()) {
				comp.setBackground(new Color(66, 113, 97));
			}
		}
		
	}
	
	public void refreshNotes(List<NoteData> lnd) {
		
		sidebar.unInit();
		nPane.getEditor().setText("");
		nPane.getViewer().setText("");
		
		scrlP.removeAll();
		
		for(NoteData note : lnd) {
			NoteInfoPanel niPanel = new NoteInfoPanel(this, note);
			scrlP.add(niPanel);
		}
		
		scrlP.revalidate();
		scrlP.repaint();
		
	}
	
}
