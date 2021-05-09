package io.github.dme6.notetaker.prompt;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public abstract class Prompt {

	private JPanel promptPanel;
	
	protected Prompt() {
		promptPanel = new JPanel();
		promptPanel.setLayout(new MigLayout());
	}
	
	protected void init(String promptTitle) {
		
		int choice = JOptionPane.showConfirmDialog(null, promptPanel, 
				promptTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(choice == JOptionPane.OK_OPTION) {
			onOptionOk();
		}
		
	}
	
	protected JPanel getPromptPanel() {
		return promptPanel;
	}
	
	protected abstract void onOptionOk();

}
