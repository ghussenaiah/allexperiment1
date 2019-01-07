package beans;

public class Test {
	
	private Test()
	{
		System.out.println("Hello Hai");
	}
 String name;
 

	public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


	public void hello()
	{
		
		System.out.println("Hello from test class"+name);
	}
}
