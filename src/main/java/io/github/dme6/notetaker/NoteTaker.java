package io.github.dme6.notetaker;

import javax.swing.SwingUtilities;

import io.github.dme6.notetaker.ui.MainFrame;
import io.github.dme6.notetaker.util.LookAndFeelLoader;

public class NoteTaker {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new LookAndFeelLoader().loadFastLAF();
				
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				
			}	
			
		});
			
	}

}
