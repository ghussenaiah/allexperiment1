
public class constructor1 {
	
	constructor1(){System.out.println("Bike is created");}
	
	public static void main(String args[]){ 
		
		constructor1 b=new constructor1();  
	}

}

/*
Java constructor is invoked at the time of object creation. 
It constructs the values i.e.
 provides data for the object that 
 is why it is known as constructor.
 Constructor name must be same as its class name
Constructor must have no explicit return type
 */
//if we are not mentioned any constructor then following 
//default constructor is created internally. 
//constructor1(){}