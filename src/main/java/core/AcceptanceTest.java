package core;

public class AcceptanceTest {

	public String name;
	public Boolean succeded;
	
	public AcceptanceTest(String name, Boolean succeded) {
		super();
		this.name = name;
		this.succeded = succeded;
	}

	@Override
	public String toString() {
		return "Name=" + name + ", Succeded=" + succeded + " ";
	}
	
}
