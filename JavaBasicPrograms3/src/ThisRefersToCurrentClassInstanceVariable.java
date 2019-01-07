
public class ThisRefersToCurrentClassInstanceVariable {

	
	void m(){  
		System.out.println(this);//prints same reference ID  
		}  
		  
		public static void main(String args[]){  
			ThisRefersToCurrentClassInstanceVariable obj=new ThisRefersToCurrentClassInstanceVariable();  
		System.out.println(obj);//prints the reference ID  
		  
		obj.m();  
		} 
}

//when we want to print object values it will print classname@hashcode
