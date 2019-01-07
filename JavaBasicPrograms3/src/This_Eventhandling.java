
public class This_Eventhandling {

	void m(This_Eventhandling obj){  
		  System.out.println("method is invoked");  
		  }  
		  void p(){  
		  m(this);  
		  }  
		    
		  public static void main(String args[]){  
			  This_Eventhandling s1 = new This_Eventhandling();  
		  s1.p();  
		  }  
}
/*this keyword can be passed as an argument in the method.

The this keyword can also be passed as an argument in the method. 
It is mainly used in the event handling. Let's see the example:

Application of this that can be passed as an argument:

In event handling (or) in a situation where we have to 
provide reference of a class to another one.
*/