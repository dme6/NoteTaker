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
import io.github.dme6.notetaker.task.ReadNotesTask;
import io.github.dme6.notetaker.ui.functionality.listener.CreateNoteListener;
import io.github.dme6.notetaker.ui.functionality.other.SimpleDelay;
import io.github.dme6.notetaker.ui.subcomponent.notepane.NotePane;
import io.github.dme6.notetaker.ui.subcomponent.notescroll.NoteScroll;
import io.github.dme6.notetaker.ui.subcomponent.notescroll.NoteScrollPanel;
import io.github.dme6.notetaker.ui.subcomponent.other.NoteTakerLabel;
import io.github.dme6.notetaker.ui.subcomponent.other.NoteInfoPanel;
import io.github.dme6.notetaker.ui.subcomponent.other.Sidebar;
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
		
		new Thread(new ReadNotesTask(cb -> {
			if(cb.getStatus() == 0) {
				refreshNotes((List<NoteData>) cb.getData());
			}
		})).start();
	}
	
	private void init() {
		
		NoteTakerLabel ntLbl = new NoteTakerLabel();
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
