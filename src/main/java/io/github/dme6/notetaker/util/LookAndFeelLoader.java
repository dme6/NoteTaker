package io.github.dme6.notetaker.util;

import javax.swing.UIManager;

public class LookAndFeelLoader {

	public void loadSystemLAF() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
