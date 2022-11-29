package commandpattern.invoker;

import commandpattern.command.Command;

public class SimpleRemoteControl {
	private Command slot;

	public SimpleRemoteControl() {
		super();
	}
	
	public void setCommand(Command command) {
		slot = command;
	}
	
	public void buttonWasPressed() {
		slot.execute();
	}
	

}
