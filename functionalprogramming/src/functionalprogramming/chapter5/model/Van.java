package functionalprogramming.chapter5.model;

public class Van extends Car{
	public Van(String name, String brand) {
		super(name, brand);
	}
	
	public void drive() {
		System.out.println("Driving a Van " + name + " from " + brand);
	}
}
