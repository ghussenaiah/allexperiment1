
public class Static_Variable {
	
	int rollno;  
	   String name;  
	   static String college ="ITS";  
	   //here static variable get memory only one time at the time of class loading.
	   //It makes your program memory efficient (i.e it saves memory).
	   //Java static property is shared to all objects.
	   Static_Variable(int r,String n){  
	   rollno = r;  
	   name = n;  
	   }  
	 void display (){System.out.println(rollno+" "+name+" "+college);}  
	  
	 public static void main(String args[]){  
		 Static_Variable s1 = new Static_Variable(111,"Karan");  
		 Static_Variable s2 = new Static_Variable(222,"Aryan");  
	   
	 s1.display();  
	 s2.display();  
	 }  

}
