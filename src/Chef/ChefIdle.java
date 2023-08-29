package Chef;

public class ChefIdle extends ChefState {

	public ChefIdle(Chef chef) {
		super(chef);
	}

	@Override
	public void doSomething() {

	}

	@Override
	public void change() {
		chef.setState(new ChefCook(chef));
	}

	@Override
	public String displayState() {
		return String.format("%s, Idle", chef.getName());
	}

}
