
public class ThisReturn {
	
	ThisReturn getA(){  
		return this;  
		}  
		void msg(){System.out.println("Hello java");}  
		}  
		  
		class Test1{  
		public static void main(String args[]){  
		new ThisReturn().getA().msg();  
		}  

}
//this not executed 
/*We can return the this keyword as an statement from the method.
 *  In such case, return type of the method must be the class type */
 