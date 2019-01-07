
public class MethodOverloading1 {

	 void sum(int a,int b){System.out.println(a+b);}  
	  void sum(double a,double b){System.out.println(a+b);}  
	  
	  public static void main(String args[]){  
   MethodOverloading1 obj=new MethodOverloading1();  
	  obj.sum(10.5,10.5);  
	  obj.sum(20,20); 
	  
	  //Example of Method Overloading by changing data type of argument
	  
	  }  
}
