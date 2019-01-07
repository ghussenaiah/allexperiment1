
public class MethodOverloadingwithTypePromotion1 {

	  
		  void sum(int a,int b){System.out.println("int arg method invoked");}  
		  void sum(long a,long b){System.out.println("long arg method invoked");}  
		  
		  public static void main(String args[]){
			  
MethodOverloadingwithTypePromotion1 obj=new MethodOverloadingwithTypePromotion1();  
		  obj.sum(20,20);
		  //now int arg sum() method gets invoked 
		  //although if we comment the void sum(int a,int b) values are 
		  //passed through void sum(long a,long b) and executed
		  }  
		}  

