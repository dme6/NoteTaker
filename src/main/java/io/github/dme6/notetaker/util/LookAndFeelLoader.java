package io.github.dme6.notetaker.util;

import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.fast.FastLookAndFeel;

public class LookAndFeelLoader {

	public void loadFastLAF() {
		
		try {
			Properties prop = new Properties();
			prop.put("logoString", "");
			FastLookAndFeel.setCurrentTheme(prop);		
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
