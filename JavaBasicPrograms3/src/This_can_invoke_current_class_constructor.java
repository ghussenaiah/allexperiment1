
public class This_can_invoke_current_class_constructor {

	
	  int id;  
	    String name;  
	    This_can_invoke_current_class_constructor(){System.out.println("default constructor is invoked");}  
	      
	    This_can_invoke_current_class_constructor(int id,String name){  
	   this ();//it is used to invoked current class constructor.  
	    this.id = id;  
	    this.name = name;  
	    }  
	    void display(){System.out.println(id+" "+name);}  
	      
	    public static void main(String args[]){  
	    	This_can_invoke_current_class_constructor e1 = new This_can_invoke_current_class_constructor(111,"karan");  
	    	This_can_invoke_current_class_constructor e2 = new This_can_invoke_current_class_constructor(222,"Aryan");  
	    e1.display();  
	    e2.display();  
	   }  
}
/*here This_can_invoke_current_class_constructor()
is not executed at the time of obejct creation.
{System.out.println("default constructor is invoked");

} 
this() can invoke the method
*/ 
