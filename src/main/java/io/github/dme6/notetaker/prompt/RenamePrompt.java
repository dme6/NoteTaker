package io.github.dme6.notetaker.prompt;

import javax.swing.JTextField;

import io.github.dme6.notetaker.data.CallbackData;
import io.github.dme6.notetaker.task.Callback;

public class RenamePrompt extends Prompt {
	
	private Callback cb;
	
	private JTextField reIn;
	
	public RenamePrompt(Callback cb) {
		
		this.cb = cb;
		
		reIn = new JTextField();
		this.getPromptPanel().add(reIn, "pushx, growx");
		
		this.init("Rename Note");
		
	}

	@Override
	protected void onOptionOk() {
		
		cb.callback(new CallbackData(0, reIn.getText()));
		
	}

}
