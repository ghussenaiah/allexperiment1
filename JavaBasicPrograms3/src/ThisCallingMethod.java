
public class ThisCallingMethod {

	
	  void m(){  
		  System.out.println("method is invoked");  
		  }  
		  void n(){  
		  m(); // or this.m() is equal to m();
		  //no need because compiler does it for you.  
		  }  
		  void p(){  
		  this.n(); //this.n() is equal to n()
		  //complier will add this to invoke n() method as this.n()  
		  }  
		  public static void main(String args[]){  
			  ThisCallingMethod s1 = new ThisCallingMethod();  
		  s1.p();  
}
}
/*The this keyword can be used to invoke current class method (implicitly).

You may invoke the method of the current class by using the this keyword. 
If you don't use the this keyword, compiler automatically adds this 
keyword while invoking the method.
*/