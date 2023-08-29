package Chef;

public class ChefCook extends ChefState {

	public ChefCook(Chef chef) {
		super(chef);
	}

	@Override
	public void doSomething() {
		try {
			Thread.sleep((6 - chef.getSpeed()) * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		change();
	}

	@Override
	public void change() {
		chef.setState(new ChefDone(chef, currentCustomer));
	}

	@Override
	public String displayState() {
		return String.format("%s, Cook<%s>", chef.getName(), currentCustomer.getName());
	}

}
