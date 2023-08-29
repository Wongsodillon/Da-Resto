package Human;

import Main.GameThread;
import Mediator.Mediator;

public abstract class Human extends GameThread {
	private String name;
	private Mediator mediator;
	public Human(String name, Mediator mediator) {
		this.name = name;
		this.mediator = mediator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}
