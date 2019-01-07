
public class AnnonymousObject {

	
	 	void fact(int  n){  
		  int fact=1;  
		  for(int i=1;i<=n;i++){  
		   fact=fact*i;  
		  }  
		 System.out.println("factorial is "+fact);  
		}  
		  
		public static void main(String args[]){  
		 new AnnonymousObject().fact(5);
		 //in general format 
		 //AnnonymousObject obj =new AnnonymousObject();
		 //here obj is name of object.
		 //calling method with annonymous object  
		}  
		}  

/*Annonymous simply means nameless.An object that have
no reference is known as annonymous object.
If you have to use an object only once, annonymous 
object is a good approach */