package io.github.dme6.notetaker.util;

import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.fast.FastLookAndFeel;

public class LookAndFeelLoader {

	public void loadFastLAF() {
		
		Properties props = new Properties();
		props.put("macStyleScrollBar", "on");
		props.put("focusColor", "100 100 100");
		props.put("windowDecoration", "off");
		FastLookAndFeel.setCurrentTheme(props);
		
		try {		
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
